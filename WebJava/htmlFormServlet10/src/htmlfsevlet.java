/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by iliashebanov on 25.03.17.
 */
public class htmlfsevlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String userName = "Shebanov";
        String userPassword = "1234";

        try (PrintWriter writer = response.getWriter()) {//для отрисовки всего html контента
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta carset=\"UTF-8\"/>");
            writer.println("<title>Заполнение текстовых полей</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Введите ваше имя и пароль:</h1>");
            writer.println("<input type=\"text\" name=\"userName\" value=\"" + userName + "\">" +
                    "<input type=\"password\" name=\"userPassord\" value=\"" + userPassword + "\">");
            writer.println("</body>");
            writer.println("</html>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
