package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoMyClientServet {

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myclientserver", "postgres", "12345");
            if (connection != null) {
                System.out.println("Мы подключились к базе");
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return connection;
    }

    public List<String> getUsersEmail() {
        ArrayList<String> userList = new ArrayList<String>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT email FROM clientinfo;");
             ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                String email = rs.getString(1);
                userList.add(email);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }
}
