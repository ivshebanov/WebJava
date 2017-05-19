/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by iliashebanov on 08.04.17.
 */
public class db_Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String srselecttable = request.getParameter("selecttable");
        try {
            Class.forName("org.postgresql.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/northwind", "postgres",
                    "12345");
            if (con2 != null) {
                System.out.println("Поключились!");
            }

            Statement st2 = con2.createStatement();
            String sql2 = "select * FROM " + srselecttable;


            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Есть выполнение");

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            PrintWriter writer = response.getWriter();

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>Выбранная таблица</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border = '1'>");
            while (rs2.next()) {
//                rs2.getMetaData().getColumnCount(); получам колличество
                writer.write("<tr><td>" + rs2.getString(1) + "</td> <td>" + rs2.getString(2) + "</td></tr>");
                System.out.println(rs2.getString(1));
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");


            rs2.close();
            st2.close();
            con2.close();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String liketxt = request.getParameter("searchtxt");
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/northwind", "postgres",
                    "12345");
            if (con != null) {
                System.out.println("Поключились!");
            }

            Statement st = con.createStatement();
            String sql = "select * from products WHERE productname LIKE \'+" + liketxt + "\'";


            ResultSet rs = st.executeQuery(sql);
            System.out.println("Есть выполнение");

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            PrintWriter writer = response.getWriter();

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>Результат поиска</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border = '1'>");
            while (rs.next()) {
                writer.write("<tr><td>" + rs.getString("productid") + "</td> <td>" + rs.getString("productname") + "</td></tr>");
                System.out.println(rs.getString("productrid"));
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");


            rs.close();
            st.close();
            con.close();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}


