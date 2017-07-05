package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by iliashebanov on 03.07.17.
 */
@WebServlet(name = "RegServlet")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userlogin = request.getParameter("userlogin");
        String userpassword = request.getParameter("userpassword");
        if (login(userlogin, userpassword)){
            RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean login(String userlogin, String userpassword){
        try (Connection connection = DbServlet.getConnection();
             Statement st = connection.createStatement();){
            String sql = "select lastname from clientinfo where lastname ='" + userlogin +"'"+
                    "and password = '" + userpassword + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
