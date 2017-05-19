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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by iliashebanov on 15.04.17.
 */
@WebServlet(name = "deleteServlet")
public class deleteServlet extends HttpServlet {

    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("JDBC драйвер загружен");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int recordAffected = 0;
        try {
            String id = request.getParameter("id");
            String sql = "DELETE FROM customers " +
                    "WHERE customerid = '" + id + "';";
            System.out.println(sql);
            Connection con = null;
            con = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1/northwind", "postgres",
                    "12345");
            Statement st = con.createStatement();
            recordAffected = st.executeUpdate(sql);
            System.out.println("Результат удаления, выводим значение recordAffected = "
                    + recordAffected);
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE> Удаление записей </TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        if (recordAffected == 1) {
            out.println("<p> Запись удалена </p>");
        } else {
            out.println("<p> Ошибка удаления записи </p>");
        }
        out.println("<a href='/proServlet'> Вернуться назад </a> к сранице поиска");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
