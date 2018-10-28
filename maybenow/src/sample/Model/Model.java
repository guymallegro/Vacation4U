package sample.Model;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;

public class Model {
    private Connection connection;
    private String currentUser;
    private HashMap<String, String> userInfo;

    public Model() {
        connection = SQLiteConnection.Connector();
    }

    public boolean login(String userName, String password) {
        String sql = "SELECT username "
                + "FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean RegisterUser(String userName, String password, LocalDate date, String firstName, String lastName, String city) {

        String sql = "INSERT INTO users(userName,password,birth,firstName,lastName,city) VALUES(?,?,?,?,?,?)";
        try (Connection conn = SQLiteConnection.Connector();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            String strdate = date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
            pstmt.setString(3, strdate);
            pstmt.setString(4, firstName);
            pstmt.setString(5, lastName);
            pstmt.setString(6, city);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateUser(String userName, String password, String birth, String firstName, String lastName, String city) {
        String sql = "UPDATE users SET username = ?, password = ?, birth = ?, firstName = ?, lastName = ?, city = ?"
                + "  WHERE username = ?";

        try (Connection conn = SQLiteConnection.Connector();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, birth);
            pstmt.setString(4, firstName);
            pstmt.setString(5, lastName);
            pstmt.setString(6, city);
            pstmt.setString(7, userName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void getInfo(String userName) {
        userInfo = new HashMap<>();
        String sql = "SELECT username,password,birth,firstName,lastName,city " +
                "FROM users WHERE username = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();
            userInfo.put("username", rs.getString("username"));
            userInfo.put("password", rs.getString("password"));
            userInfo.put("birth", rs.getString("birth"));
            userInfo.put("firstName", rs.getString("firstName"));
            userInfo.put("lastName", rs.getString("lastName"));
            userInfo.put("city", rs.getString("city"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public HashMap<String, String> getUserInfo() {
        return userInfo;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String userName) {
        currentUser = userName;
    }

}