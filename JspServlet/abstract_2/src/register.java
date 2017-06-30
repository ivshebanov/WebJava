import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//
//        try (PrintWriter writer = response.getWriter()) {
//            writer.println("<!DOCTYPE html><html>");
//            writer.println("<head>");
//            writer.println("<meta charset=\"UTF-8\" />");
//            writer.println("<title>POST</title>");
//            writer.println("</head>");
//            writer.println("<body>");
//
//            writer.println("<h1>Сработал метод пост</h1>");
//            writer.println("Строка запроса " +request.getQueryString() + "</br>");
//            Enumeration enumeration = request.getParameterNames();
//            while (enumeration.hasMoreElements()){
//                String parametrName = (String) enumeration.nextElement();
//                writer.println("Имя параметра: " + request.getParameter(parametrName) + "</br>");
//            }
//
//            String userName = request.getParameter("userName");
//            String password = request.getParameter("password");
//            if(userName!=null && password!=null &&userName.equals("ilya") && password.equals("12345"))
//            {
//                response.sendRedirect("/welcome.jsp");
//            }
//            else
//            {
//                response.sendRedirect("/index.jsp");
//            }
//
//
//            writer.println("</body>");
//            writer.println("</html>");
//
//        }

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(userName!=null && password!=null &&userName.equals("ilya") && password.equals("12345"))
        {

//response.sendRedirect("/welcome.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
            rd.forward(request, response);
        }
        else
        {
            //response.sendRedirect("/index.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>GET</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>Сработал метод get</h1>");
            writer.println("Строка запроса " +request.getQueryString() + "</br>");
//            Enumeration enumeration = request.getParameterNames();
//            while (enumeration.hasMoreElements()){
//                String parametrName = (String) enumeration.nextElement();
//                writer.println("Имя параметра: " + request.getParameter(parametrName) + "</br>");
//            }

            String [] values = request.getParameterValues("favoriteMusic");
            if(values!=null)
            {
                writer.print("Вы выбрали: ");
                for (int i=0; i<values.length; i++)
                {
                    writer.println("<br/>" + values[i]);
                }
            }
            writer.println("</body>");
            writer.println("</html>");

        }
    }
}