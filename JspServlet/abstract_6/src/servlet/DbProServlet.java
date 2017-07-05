package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DbProServlet extends javax.servlet.http.HttpServlet {
    private String keyword = "";
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
        keyword = request.getParameter("keyword");
        sendPageHeader(response);
        sendSearchForm(response);
        sendSearchResult(response);
        sendPageFooter(response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        sendPageHeader(response);
        sendSearchForm(response);
        sendPageFooter(response);

    }

    private void sendPageHeader(HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Отображение выбранных записей</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
    }

    private void sendSearchForm(HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<BR><H2>Поиск</H2>");
        out.println("<BR>Введите имя компании или контактного лица");
        out.println("<BR>");
        out.println("<BR><FORM METHOD=POST>");
        out.print("Name: <INPUT TYPE=TEXT Name=keyword");
        out.print(" VALUE=\"" + keyword + "\"");
        out.println(">");
        out.println("<INPUT TYPE=SUBMIT>");
        out.println("</FORM>");
        out.println("<BR>");
        out.println("<BR>");
    }

    void sendSearchResult(HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/northwind", "postgres",
                    "12345");
            System.out.println("Есть подключение");
            Statement s = con.createStatement();
            out.println("<TABLE border = '1'>");
            out.println("<TR>");
            out.println("<TH>Customerid</TH>");
            out.println("<TH>Companyname</TH>");
            out.println("<TH>Contactname</TH>");
            out.println("<TH>Contacttitlee</TH>");
            out.println("<TH>Address</TH>");
            out.println("<TH></TH>");
            out.println("<TH></TH>");
            out.println("</TR>");
            String sql =
                    "SELECT *" +
                            " FROM Customers" +
                            " WHERE companyname LIKE '%" + keyword + "%'" +
                            " OR contactname LIKE '%" +keyword + "%'";
            System.out.println(sql);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                out.println("<TR>");
                out.println("<TD>" + rs.getString(1)
                        + "</TD>");
                out.println("<TD>" + rs.getString(2)
                        + "</TD>");
                out.println("<TD>" + rs.getString(3)
                        + "</TD>");
                out.println("<TD>" + rs.getString(4)
                        + "</TD>");
                out.println("<TD>" + rs.getString(5)
                        + "</TD>");
                out.println("<TD><A HREF=DeleteServlet?id=" + id +
                        ">Delete</A></TD>");
                out.println("<TD><A HREF=UpdateServlet?id=" + id +
                        ">Update</A></TD>");
                out.println("</TR>");
            }
            s.close();
            con.close();
        }
        catch (SQLException e) {
        }
        catch (Exception e) {
        }
        out.println("</TABLE>");
    }

    private void sendPageFooter(HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
