package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by iliashebanov on 05.07.17.
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private String dbURL = "jdbc:postgresql://localhost:5432/northwind";
    private String dbUser = "postgres";
    private String dbPass = "12345";

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
        sendPageHeader(response);
        updateRecord(request, response);
        sendPageFooter(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendPageHeader(response);
        sendUpdateForm(request, response);
        sendPageFooter(response);
    }

    private void sendPageHeader(HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Обновление записей</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
    }

    private void sendPageFooter(HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    private void sendUpdateForm(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        out.println("<BR><H2>Редактирование записи</H2>");
        out.println("<BR>Отредактируйте поля");
        out.println("<BR>");
        try {
            String sql = "SELECT companyname, contactname," +
                    " contacttitle, address" +
                    " FROM customers" +
                    " WHERE customerid= '" + id + "'";
            Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                String companyname = rs.getString(1);
                String contactname = rs.getString(2);
                String contacttitle = rs.getString(3);
                String address = rs.getString(4);
                out.println("<BR><FORM METHOD=POST ACTION=" +
                        request.getRequestURI() + "?id=" + id + ">");
                out.println("<TABLE>");
                out.println("<TR>");
                out.println("<TD>companyname</TD>");
                out.print("<TD><INPUT TYPE=TEXT Name=companyname");
                out.print(" VALUE=\"" + companyname
                        + "\"");
                out.println("></TD>");
                out.println("</TR>");
                out.println("<TR>");
                out.println("<TD>contactname</TD>");
                out.print("<TD><INPUT TYPE=TEXT Name=contactname");
                out.print(" VALUE=\"" + contactname
                        + "\"");
                out.println("></TD>");
                out.println("</TR>");
                out.println("<TR>");
                out.println("<TD>contacttitle</TD>");
                out.print("<TD><INPUT TYPE=TEXT Name=contacttitle");
                out.print(" VALUE=\"" + contacttitle
                        + "\"");
                out.println("></TD>");
                out.println("<TR>");
                out.println("<TD>address</TD>");
                out.print("<TD><INPUT TYPE=TEXT Name=address");
                out.print(" VALUE=\"" + address
                        + "\"");
                out.println("></TD>");
                out.println("</TR>");
                out.println("<TR>");
                out.println("<TD><INPUT TYPE=RESET></TD>");
                out.println("<TD><INPUT TYPE=SUBMIT></TD>");
                out.println("</TR>");
                out.println("</TABLE>");
                out.println("</FORM>");
            }
            s.close();
            con.close();
        }
        catch (SQLException e) {
            out.println(e.toString());
        }
        catch (Exception e) {
            out.println(e.toString());
        }
    }
    void updateRecord(HttpServletRequest request, HttpServletResponse
            response) throws IOException {
        String id = request.getParameter("id");
        String companyname = request.getParameter("companyname");
        String contactname = request.getParameter("contactname");
        String contacttitle = request.getParameter("contacttitle");
        PrintWriter out = response.getWriter();
        try {
            String sql = "UPDATE customers" +
                    " SET companyname='" + companyname +
                    "'," + " contactname='" + contactname + "'," +
                    " contacttitle='" + contacttitle + "'" +
                    " WHERE customerid= '" + id + "'";
            System.out.println(sql);
            Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
            Statement s = con.createStatement();
            int i = s.executeUpdate(sql);
            if (i == 1)
                out.println("Запись обновлена<br/>");
            else
                out.println("Ошибка обновления записей");
            s.close();
            con.close();
        }
        catch (SQLException e) {
            out.println(e.toString());
        }
        catch (Exception e) {
            out.println(e.toString());
        }
        out.println("<A HREF=/pro>Вернуться назад</A> на страницу поиска");
    }

}
