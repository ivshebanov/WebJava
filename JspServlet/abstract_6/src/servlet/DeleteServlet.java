package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("JDBC driver загружен");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int recordAffected = 0;
        try {
            String id = request.getParameter("id");
            String sql = "DELETE FROM customers WHERE customerid= '" + id + "'";
            System.out.println(sql);
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/northwind", "postgres",
                    "12345");
            Statement s = con.createStatement();
            recordAffected = s.executeUpdate(sql);
            s.close();
            con.close();
        }
        catch (SQLException e) {
        }
        catch (Exception e) {
        }
        response.setContentType("text/html");

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Удаление записи</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        if (recordAffected == 1)
            out.println("<P>Запись удалена.</P>");
        else
            out.println("<P>Ошибка удаления записи.</P>");
        out.println("<A HREF=/pro>Вернуться назад</A> к странице поиска");
    }

}
