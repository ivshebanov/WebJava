import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class firstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>Это заголовок первого сервлета</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>Сработал первый сервлет</h1>");
            writer.println(escapeHtml("Это теги HTML <br/>, <hr>, <b>привет </b>"));

            writer.println("</body>");
            writer.println("</html>");

        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init");
        super.init();
    }

    public static String escapeHtml(String string) {
        String escapedTxt = "";
        char tmp = ' ';
        for(int i = 0; i < string.length(); i++) {
            tmp = string.charAt(i);
            switch (tmp) {
                case '<':
                    escapedTxt += "&lt;";
                    break;
                case '>':
                    escapedTxt += "&gt;";
                    break;
                case '&':
                    escapedTxt += "&amp;";
                    break;
                case '"':
                    escapedTxt += "&quot;";
                    break;
                case '\'':
                    escapedTxt += "&#x27;";
                    break;
                case '/':
                    escapedTxt += "&#x2F;";
                    break;
                default:
                    escapedTxt += tmp;
            }
        }
        return escapedTxt;
    }

}

