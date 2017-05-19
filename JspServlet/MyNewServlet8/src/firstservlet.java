/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by iliashebanov on 25.03.17.
 */
public class firstservlet extends javax.servlet.http.HttpServlet {

//    firstservlet(){
//        System.out.println("Сработал конструтор");
//    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Инициализация");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("Сервис");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Выключение");
    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()) {//для отрисовки всего html контента
            writer.println("<!DOCTYPE html><html>" +
                    "<head>" +
                    "<meta carset=\"UTF-8\"/>" +
                    "<title> Это загловок первого сервлета</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>Сработал первый сервлет</h1>" +
                    "</body>" +
                    "</html>");
//            writer.println("<meta carset=\"UTF-8\"/>");
//            writer.println("<title> Это загловок первого сервлета</title>");
//            writer.println("</head>");
//            writer.println("<body>");
//            writer.println("<h1>Сработал 1 сервлет</h1>");
//            writer.println("</body>");
//            writer.println("</html>");
            System.out.println("это консоль");
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
