import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by iliashebanov on 02.04.17.
 */
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        if (!firstName.isEmpty() && !lastName.isEmpty() && !sex.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {
            DaoUser.addUser(firstName, lastName, sex, email, phone, address);
            response.sendRedirect("/users");
        } else {
            request.getRequestDispatcher("checkIn.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
