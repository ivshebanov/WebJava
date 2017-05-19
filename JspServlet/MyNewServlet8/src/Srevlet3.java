/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by iliashebanov on 25.03.17.
 */
public class Srevlet3 extends javax.servlet.http.HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = resp.getWriter()) {//для отрисовки всего html контента
            writer.println("<!DOCTYPE html><html>" +
                    "<head>" +
                    "<meta carset=\"UTF-8\"/>" +
                    "<title> Это загловок третий сервлета</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>Сработал третий сервлет Get</h1>" +
                    "</body>" +
                    "</html>");
            System.out.println("это консоль");
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
