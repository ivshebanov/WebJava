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
import java.util.Enumeration;

/**
 * Created by iliashebanov on 25.03.17.
 */
@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>POST</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Сработал метод пост</h1>");
//            String [] values = request.getParameterValues("favoriteMusic");
//            if(values!=null)
//            {
//                writer.print("Вы выбрали: ");
//                for (int i=0; i<values.length; i++)
//                {
//                    writer.println("<br/>" + values[i]);
//                }
//            }

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            if (userName!= null && password != null && userName.equals("Shebanov") && password.equals("1234")){
                response.sendRedirect("/Welcom.html");
            }else {
                response.sendRedirect("/index.jsp");
            }

            writer.println("</body>");
            writer.println("</html>");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>POST</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Сработал метод гет</h1>");
            writer.println("Строка запроса " + request.getQueryString() + "</br>");
            Enumeration enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()) {
                String parametr = (String) enumeration.nextElement();
                writer.println("элементы: " + request.getParameter(parametr) + "</br>");
            }
            writer.println("</body>");
            writer.println("</html>");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
