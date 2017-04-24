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
 * Created by iliashebanov on 25.03.17.
 */

@WebServlet(name = "regist")
public class regist extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8"); //добавляем кодировку страныцы
        request.setCharacterEncoding("UTF-8");  // добавляем кодировку переменным

//        try (PrintWriter writer = response.getWriter()) {//для отрисовки всего html контента
//            writer.println("<!DOCTYPE html><html>");
//            writer.println("<head>");
//            writer.println("<meta carset=\"UTF-8\"/>");
//            writer.println("<title> Это загловок первого сервлета</title>");
//            writer.println("</head>");
//            writer.println("<body>");
//            writer.println("<h1>Сработал второй сервлет regist запрос Get</h1>");
//            writer.println("Строка запроса " + request.getQueryString() + "</br>");
//            Enumeration enumeration = request.getParameterNames();
//            while (enumeration.hasMoreElements()) {
//                String paramName = (String) enumeration.nextElement();
//                writer.println("Имя параметра " + request.getParameter(paramName) + "</br>");
//            }
//            writer.println("</body>");
//            writer.println("</html>");
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//        }

        try (PrintWriter writer = response.getWriter()) {
//            String[] znachen = request.getParameterValues("space");
//            if (znachen != null) {
//                writer.println("Вы выбрали: ");
//                for (int i = 0; i < znachen.length; i++) {
//                    writer.println("<br/>" + znachen[i]);
//                }
//            }

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            if (userName != null && password != null && userName.equals("Shebanov") && password.equals("Sxsblp")) {
                response.sendRedirect("/welcome.jsp");
            } else {
                response.sendRedirect("/index.jsp");
            }


        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()) {//для отрисовки всего html контента
//            writer.println("<!DOCTYPE html><html>");
//            writer.println("<head>");
//            writer.println("<meta carset=\"UTF-8\"/>");
//            writer.println("<title> Это загловок первого сервлета</title>");
//            writer.println("</head>");
//            writer.println("<body>");
//            writer.println("<h1>Сработал второй сервлет regist запрос Get</h1>");
//            writer.println("Строка запроса " + request.getQueryString() + "</br>");
//            Enumeration enumeration = request.getParameterNames();
//            while (enumeration.hasMoreElements()) {
//                String paramName = (String) enumeration.nextElement();
//                writer.println("Имя параметра " + request.getParameter(paramName) + "</br>");
//            }
//            writer.println("</body>");
//            writer.println("</html>");

            String ansver = request.getParameter("ansve");

            if (ansver.equals("весна")) {
                response.sendRedirect("/welcome.jsp");
            } else {
                response.sendRedirect("/index.jsp");
//                response.sendRedirect("");
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}