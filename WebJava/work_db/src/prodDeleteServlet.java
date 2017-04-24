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
@WebServlet(name = "prodDeleteServlet")
public class prodDeleteServlet extends HttpServlet {

    private String keyword = "";

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
        keyword = request.getParameter("keyword");
        sendPageHeader(response);
        sendSearchForm(response);
        sendSearchResult(response);
        sendPageFooter(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sendPageHeader(response);
        sendSearchForm(response);
        sendPageFooter(response);
    }

    private void sendSearchResult(HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1/northwind", "postgres",
                    "12345");
            Statement st = con.createStatement();
            out.println("<TABLE border='1'>");
            out.println("<TR>");
            out.println("<TH>Customerid</TH>");
            out.println("<TH>Companiname</TH>");
            out.println("<TH>Contactname</TH>");
            out.println("<TH>Contacttitle</TH>");
            out.println("<TH>Address</TH>");
            out.println("<TH>Редактировать</TH>");
            out.println("<TH>Удалить</TH>");
            out.println("</TR>");
            String sql = "SELECT productid, productname, supplierid, categoryid " +
                    "FROM products " +
                    "WHERE productname LIKE '%" + keyword + "%'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("<td><a href='prodServletDel?id=" + id + "'>" +
                        "Удалить</a></td>");
                out.println("<td><a href='updateservlet?id=" + id + "'>" +
                        "Редактировать</a></td>");
                out.println("</tr>");
            }
            st.cancel();
            con.close();
            out.println("</TABLE>");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendPageHeader(HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE> Отображение выбранных записей </TITLE>");
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

    private void sendSearchForm(HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<br/><h2>Поиск по базе</h2>");
        out.println("<br/>Введите имя компании и контактного лица<br/>");
        out.println("<br/> <FORM METHOD = 'POST'>");
        out.println("  Имя: <INPUT type=\"text\" name=\"keyword\"");
        out.println("value=" + keyword + "");
        out.println(">");
        out.println("<INPUT type=\"SUBMIT\">");
        out.println("<FORM/><br/><br/>");
    }
}
