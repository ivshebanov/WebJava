import java.io.IOException;
import java.io.PrintWriter;

public class firstservlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("firstservlet");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>Это заголовок первого сервлета</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Сработал первый сервлет</h1>");
            writer.println("</body>");
            writer.println("</html>");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
