package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DbServlet")
public class DbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String liketxt = request.getParameter("searchtxt");
        try (Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            String sql = "select * from products where productname like \'%" + liketxt + "%\'" ;
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Есть выполнение");
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            try (PrintWriter writer = response.getWriter()) {

                writer.println("<!DOCTYPE html><html>");
                writer.println("<head>");
                writer.println("<meta charset=\"UTF-8\" />");
                writer.println("<title>Результат поиска в базе</title>");
                writer.println("</head>");
                writer.println("<body>");

                writer.println("<table border=\"1\">");
                while (rs.next())
                {
                    writer.println("<tr ><td >" + rs.getString("productid")+" </td ><td >" +rs.getString("productname")+"</td ></tr >");
                }
                writer.println("</table>");

                writer.println("</body>");
                writer.println("</html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try (Connection connection = getConnection()){
//            Statement statement = connection.createStatement();
//            String sql = "select * from customers";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()){
//                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
//            }
////            String sql = "insert into ClientInfo (FirstName, LastName, Address, Phone) " +
////                    "values('Chingiz','Kariev','Chehova 13','1234567')";
////            String sql = "update ClientInfo set FirstName = 'Andrey' where FirstName = 'Chingiz'";
////            String sql = "delete from ClientInfo where LastName like 'Kariev'";
////            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String liketxt = request.getParameter("selecttable");
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from " + liketxt +";";
            ResultSet rs = statement.executeQuery(sql);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            try (PrintWriter writer = response.getWriter()) {
                writer.println("<!DOCTYPE html><html>");
                writer.println("<head>");
                writer.println("<meta charset=\"UTF-8\" />");
                writer.println("<title>Результат поиска в базе</title>");
                writer.println("</head>");
                writer.println("<body>");
                writer.println("<table border=\"1\">");
                while (rs.next()) {
                    writer.println("<tr><td >" + rs.getString(1) + " </td><td >" + rs.getString(2) + "</td ></tr >");
                }
                writer.println("</table>");
                writer.println("</body>");
                writer.println("</html>");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/northwind",
                    "postgres", "12345");
            assert connection != null;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
