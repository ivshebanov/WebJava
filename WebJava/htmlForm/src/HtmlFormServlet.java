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

/**
 * Created by iliashebanov on 26.03.17.
 */
@WebServlet(name = "HtmlFormServlet")
public class HtmlFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String userName = "Shebanov";
        String userPassword = "12345";


        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>Заполнение HTML-форм</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h3>Ваше имя и пароль:</h3>");
            writer.println("<input type=text name = userName value =\"" + userName + "\">");
            writer.println("<input type=password name = userPassword value =\"" + userPassword + "\">");
            writer.println("</body>");
            writer.println("</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
