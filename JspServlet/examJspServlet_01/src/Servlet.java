import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendSqlForm(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendSqlForm(request, response);
    }

    private void sendSqlForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\" />");
            out.println("<title>SQLServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<br>Введите запрос<br>");
            out.println("<br><form method=POST>");
            out.println("<textarea name=sql cols=80 rows=8>");
            String sql = request.getParameter("sql");
            // Перепечатка предыдущего введенного запроса в текстовую область
            if (sql != null)
                out.println(sql);
            out.println("</textarea>");
            out.println("<br>");
            out.println("<INPUT TYPE=SUBMIT VALUE=\"Выполнить запрос\">");
            out.println("</form>");
            out.println("<br><hr><br>");
            if (sql != null) {
                executeSql(sql.trim(), response);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void executeSql(String sql, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter();
             Connection connection = getConnection();
             Statement statement = connection.createStatement()
        ) {
            if (sql.toUpperCase().startsWith("SELECT")) {
                out.println("<table border=1>");
                ResultSet rs = statement.executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                // Написание таблицы заголовков
                int columnCount = rsmd.getColumnCount();
                out.println("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    out.println("<td><b>" + rsmd.getColumnName(i) + "</b></td>\n");
                }
                out.println("</tr>");
                while (rs.next()) {
                    out.println("<tr>");
                    for (int i = 1; i <= columnCount; i++) {
                        out.println("<td>" + rs.getString(i) + "</td>");
                    }
                    out.println("</tr>");
                }
                rs.close();
                out.println("</table>");
            } else {
                //DML пройдут тут
                int i = statement.executeUpdate(sql);
                out.println("Запись(сей) извлечено: " + i);
            }
            out.println("</table>");
        } catch (Exception ex) {
//            out.println("<b>Ошибка</b>");
//            out.println("<br>");
            ex.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/northwind", "postgres", "12345");
            if (connection != null) {
                System.out.println("123");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}