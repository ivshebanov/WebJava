/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "NewServlet")
public class NewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userLogin = request.getParameter("userlogin");
        String userPassword = request.getParameter("userpassword");
        System.out.println(userLogin);
        System.out.println(userPassword);

        if (metodLogin(userLogin, userPassword)) {
            RequestDispatcher rd = request.getRequestDispatcher("/welcom.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    private boolean metodLogin(String userLogin, String userPassword) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/northwind", "postgres",
                    "12345");
            if (con2 != null) {
                System.out.println("Поключились!");
            }
            java.sql.Statement st = con2.createStatement();
            String s = "SELECT lastname FROM clientinfo WHERE lastname = '" + userLogin + "'" + " and password = '" + userPassword + "'";
            System.out.println(s);
            ResultSet rs = st.executeQuery(s);
            if (rs.next()) {
                rs.close();
                st.close();
                con2.close();
                return true;
            } else {
                rs.close();
                st.close();
                con2.close();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
