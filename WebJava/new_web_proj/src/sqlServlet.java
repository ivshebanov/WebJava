/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by iliashebanov on 08.04.17.
 */
@WebServlet(name = "sqlServlet")
public class sqlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendSqlFrom(request, response);
    }

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("JDBC драйер загружен");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void sendSqlFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html><html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\" />");
        writer.println("<title>работа с БД</title>");
        writer.println("</head>");
        writer.println("<body>");

        writer.write("<form method=\"post\">");
        writer.write("<h3> SQL Tool для работы с БД Northwing</h3>");
        writer.write("<p>Введите запрос</p>");
        writer.write("<textarea  rows=\"10\" cols=\"45\" type=\"text\" name=\"sqltext\">select * from customers</textarea></br>");

        String sqlstr = request.getParameter("sqltext");
        if (sqlstr != null) {
            writer.write(sqlstr);
        }
        writer.write("</textarea>");
        writer.write("</br>");
        writer.write("<input type=\"submit\" value=\"Выполнить запрос\"></form>");
        writer.write("</form>");
        writer.write("</br>");
        writer.write("</br>");
        writer.write("</br>");

        if (sqlstr != null) {
            metodExecuteSql(sqlstr.trim(), response);
        }

        writer.println("</body>");
        writer.println("</html>");
    }

    private void metodExecuteSql(String sqlstr, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/northwind", "postgres",
                    "12345");
            if (con != null) {
                System.out.println("Поключились!");
            }

            java.sql.Statement st = con.createStatement();
            if (sqlstr.toUpperCase().startsWith("SELECT")) {
                writer.println("<table border = '1'>");
                ResultSet rs = st.executeQuery(sqlstr);
                ResultSetMetaData rsmd = rs.getMetaData();
                int colum = rsmd.getColumnCount();
                writer.write("<tr>");
                for (int i = 1; i <= colum; i++) {
                    writer.write("<td><b>" + rsmd.getCatalogName(i) + "</b></td>\n");
                }
                writer.write("</tr>");
                while (rs.next()) {
                    writer.write("<tr>");
                    for (int i = 1; i <= colum; i++) {
                        writer.write("<td>" + rs.getString(i) + "</td>");
                    }
                    writer.write("</tr>");
                }
                rs.close();
                writer.write("</table>");
            } else {
                int i = st.executeUpdate(sqlstr);
                writer.write("запись извлечена" + i);
            }
            st.close();
            con.close();
            writer.write("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
