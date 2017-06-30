package servlet;

import java.io.IOException;
import java.io.PrintWriter;

public class HtmlFormServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = "ilya";
        String userPassword = "12345";
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

//        try (PrintWriter writer = response.getWriter();) {
//            writer.println("<!DOCTYPE html><html>");
//            writer.println("<head>");
//            writer.println("<meta charset=\"UTF-8\" />");
//            writer.println("<title>Заполнение HTML-форм</title>");
//            writer.println("</head>");
//            writer.println("<body>");
//            writer.println("<h3>Ваше имя и пароль:</h3>");
//            writer.println("<input type=text name = userName value =\"" + userName + "\">");
//            writer.println("<input type=password name = userPassword value =\"" + userPassword + "\">");
//            writer.println("</body>");
//            writer.println("</html>");
//        }

        try (PrintWriter writer = response.getWriter();){
            writer.println("<h3>Ваше имя и пароль:</h3>");
            writer.println("<input type=text name = userName value =\""+ userName+"\">");
            writer.println("<input type=password name = userPassword value =\""+userPassword+"\">");
        }
    }
}
