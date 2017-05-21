import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String txt = request.getParameter("txt");
        String sql = "SELECT * FROM products WHERE productname LIKE \'" + txt + "\'";
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql);
             PrintWriter out = response.getWriter();
        ) {
            out.println("<!DOCTYPE html><html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\"/>");
            out.println("<title>Результат поиска в базе</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=\"1\">");
            while (rs.next()) {
                out.println("<tr ><td >" + rs.getString("productid") + " </td ><td >" + rs.getString("productname") + "</td ></tr >");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

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