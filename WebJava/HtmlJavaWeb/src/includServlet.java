import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

public class includServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html><html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\" />");
        writer.println("<title>Заполнение HTML-форм</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<p>по Русски</p>");

        RequestDispatcher header = request.getRequestDispatcher("index.jsp");
        header.include(request, response);

        RequestDispatcher footer = request.getRequestDispatcher("footer.html");
        footer.include(request, response);

        RequestDispatcher htmlFormS = request.getRequestDispatcher("/xyz");
        htmlFormS.include(request, response);

        RequestDispatcher serv3 = request.getRequestDispatcher("/qwe");
        serv3.include(request, response);


        writer.println("</body>");
        writer.println("</html>");
    }
}
