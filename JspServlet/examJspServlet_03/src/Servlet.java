import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        userName = request.getParameter("userName");
        password = request.getParameter("password");

        if (page == null) {
            sendPage1(response);
            return;
        }
        if (page.equals("1")) {
            if (firstName == null || lastName == null)
                sendPage1(response);
            else
                sendPage2(response);
        } else if (page.equals("2")) {
            if (firstName == null || lastName == null ||
                    userName == null || password == null)
                sendPage1(response);
            else
                displayValues(response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendPage1(response);
    }

    private void sendPage1(HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(response.getCharacterEncoding());

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\"/>");
            out.println("<title>Страница 1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h2>Страница 1</h2>");
            out.println("<br>");
            out.println("Пожалуйста, введите Ваше имя и фамилию.");
            out.println("<br>");
            out.println("<br>");
            out.println("<form method=post>");
            out.println("<input type=hidden name=page value=1>");
            out.println("<table");
            out.println("<tr>");
            out.println("<td>Имя&nbsp;</td>");
            out.println("<td><input type=text name=firstName></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Фамилия&nbsp;</td>");
            out.println("<td><input type=text name=lastName></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type=reset></td>");
            out.println("<td><input type=submit value=Submit></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendPage2(HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(response.getCharacterEncoding());

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\"/>");
            out.println("<title>Страница 1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h2>Страница 2</h2>");
            out.println("<br>");
            out.println("Пожалуйста, введите ваше имя пользователя и пароль");
            out.println("<BR>");
            out.println("<BR>");
            out.println("<FORM METHOD=POST>");
            out.println("<input type=hidden name=page value=2>");
            out.println("<input type=hidden name=firstName value=\"" + firstName + "\"></td>");
            out.println("<input type=hidden name=lastName value=\"" + lastName + "\"></td>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Имя пользователя&nbsp;</td>");
            out.println("<td><input type=text name=userName></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Пароль&nbsp;</td>");
            out.println("<td><input type=password name=password></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type=reset></td>");
            out.println("<td><input type=submit value=Submit></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void displayValues(HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(response.getCharacterEncoding());

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\"/>");
            out.println("<title>Страница 3</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h2>Страница 3</h2>");
            out.println("<br>");
            out.println("Вы ввели следующие значения.");
            out.println("<br>");
            out.println("<br>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Имя: &nbsp;</td>");
            out.println("<td>" + firstName + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Фамилия: &nbsp;</td>");
            out.println("<td>" + lastName + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Имя пользователя: &nbsp;</td>");
            out.println("<td>" + userName + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Пароль: &nbsp;</td>");
            out.println("<td>" + password + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
