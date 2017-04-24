import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by iliashebanov on 03.04.17.
 */
public class EntranceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter writer = response.getWriter();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (!email.isEmpty() && !phone.isEmpty()) {
            if (DaoUser.checkUser(email, phone)) {
                response.sendRedirect("/users");
            } else {
                response.sendRedirect("/index.jsp");
            }
        } else {
            response.sendRedirect("/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
