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
 * Created by iliashebanov on 15.04.17.
 */
@WebServlet(name = "updateServlet")
public class updateServlet extends HttpServlet {
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
        sendPageHeader(response);
        sendRecord(request, response);
        sendPageFooter(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sendPageHeader(response);
        sendUpdateForm(request, response);
        sendPageFooter(response);
    }

    private void sendPageHeader(HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE> Обновление записей </TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
    }

    private void sendPageFooter(HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    private void sendUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        out.println("<br/><h2> Редактирование записи<h2>");
        out.println("<br/> Отредактируйте поля <br/>");
        try {
            String sql = "SELECT companyname, contactname, contacttitle, address " +
                    "FROM customers " +
                    "WHERE customerid = '" + id + "';";
            Connection con = null;
            con = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1/northwind", "postgres",
                    "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String companyname = rs.getString(1);
                String contactname = rs.getString(2);
                String contacttitle = rs.getString(3);
                String address = rs.getString(4);
                out.println("</br> <form method = 'post' action="
                        + request.getRequestURI() + "?id=" + id + ">");
                out.println("<TABLE>");

                out.println("<tr>");
                out.println("<td> companyname </td>");
                out.println("<td> <input type='text' name='companyname'");
                out.println("value =\"" + companyname + "\"");
                out.println("></td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td> contactname </td>");
                out.println("<td> <input type='text' name='contactname'");
                out.println("value =\"" + contactname + "\"");
                out.println("></td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td> contacttitle </td>");
                out.println("<td> <input type='text' name='contacttitle'");
                out.println("value =\"" + contacttitle + "\"");
                out.println("></td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td> address </td>");
                out.println("<td> <input type='text' name='address'");
                out.println("value =\"" + address + "\"");
                out.println("></td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td> <input type='reset'></td>");
                out.println("<td> <input type='submit'></td>");

                out.println("</tr>");
                out.println("</TABLE>");
                out.println("</form>");
            }
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.toString());
        }
    }

    private void sendRecord(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String companyname = request.getParameter("companyname");
        String contactname = request.getParameter("contactname");
        String contacttitle = request.getParameter("contacttitle");
        PrintWriter out = response.getWriter();

        try {
            String sql = "UPDATE customers SET companyname = '" + companyname + "', contactname='" + contactname + "', contacttitle='" + contacttitle + "' WHERE customerid='" + id + "';";
            System.out.println(sql);

            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1/northwind", "postgres",
                    "12345");
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            if (i == 1) {
                out.println("Запись обновлена<br>/");
            } else {
                out.println("Ощибка обновления записи<br>/");
            }
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.toString());
        }
        out.println("<a href='/proServlet'>Вернуться назад на страницу поиска");
    }
}
