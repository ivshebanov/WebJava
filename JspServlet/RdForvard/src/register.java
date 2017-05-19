import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userName != null && password != null && userName.equals("Shebanov") && password.equals("123")) {
            RequestDispatcher rd = request.getRequestDispatcher("/Welcom.jsp");
            rd.forward(request, response);
        }else {
            response.sendRedirect("/index.jsp");
//            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
//            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
