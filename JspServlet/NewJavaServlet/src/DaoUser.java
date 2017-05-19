import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by iliashebanov on 02.04.17.
 */
public class DaoUser {
    private static HashMap<String, User> guestbook = new HashMap<String, User>();

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myclientserver", "postgres", "12345");
            if (connection != null) {
                System.out.println("База подключена!");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        return connection;
    }

    public static List<User> getUsers() {
        ArrayList<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT firstName, lastName, sex, email, phone, address FROM guestbook");
             ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                String sex = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                String address = rs.getString(6);
                userList.add(new User(firstName, lastName, sex, email, phone, address));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    private static void initGuestbook() {
        List<User> users = getUsers();
        for (User us : users) {
            guestbook.put(us.getEmail(), us);
        }
    }

    public static void main(String[] args) {
        System.out.println(getUsers());
    }

    public static void addUser(String firstName, String lastName, String sex, String email, String phone, String address) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO guestbook (firstname, lastname, sex, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)");
        ) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, sex);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean checkUser(String email, String phone) {
        initGuestbook();
        boolean check = false;
        User user = null;
        try {
            user = guestbook.get(email);
            if (user.getPhone().equals(phone)) {
                check = true;
            }
        } catch (NullPointerException ex) {
            System.out.println("Такого мэйла нет");
        }
        return check;
    }

//    public static void delletePost(int id) {
//        try (Connection connection = getConnection();
//             PreparedStatement ps = connection.prepareStatement("DELETE FROM posts WHERE id = ?");
//        ) {
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
}
