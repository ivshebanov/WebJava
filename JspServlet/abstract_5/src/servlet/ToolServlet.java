package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ToolServlet")
public class ToolServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = request.getParameter("sql");
        assert sql != null;
        System.out.println(sql);
        executeSql(sql.trim(), response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void executeSql(String sql, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try (Connection con = DbServlet.getConnection();
             Statement s = con.createStatement();
             ) {
            if (sql.toUpperCase().startsWith("SELECT")) {
                out.println("<TABLE BORDER=1>");
                ResultSet rs = s.executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                // Написание таблицы заголовков
                int columnCount = rsmd.getColumnCount();
                out.println("<TR>");
                for (int i=1; i<=columnCount; i++) {
                    out.println("<TD><B>" + rsmd.getColumnName(i) + "</B></TD>\n");
                }
                out.println("</TR>");
                while (rs.next()) {
                    out.println("<TR>");
                    for (int i=1; i<=columnCount; i++) {
                        out.println("<TD>" + rs.getString(i) + "</TD>" );
                    }
                    out.println("</TR>");
                }
                rs.close();
                out.println("</TABLE>");
            }
            else {
                int i = s.executeUpdate(sql);
                out.println("Запись(сей) извлечено: " + i);
            }
            out.println("</TABLE>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
