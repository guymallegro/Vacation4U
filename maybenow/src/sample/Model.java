package sample;

import java.sql.*;

public class Model {
    Connection connection;

    public Model() {
        connection = SQLiteConnection.Connector();
    }

    public boolean login(String userName, String password) throws SQLException {
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

    public boolean RegisterUser(String userName,String password,String birth,String firstName,String lastName,String city) throws SQLException {

        String sql = "INSERT INTO users(userName,password,birth,firstName,lastName,city) VALUES(?,?,?,?,?,?)";

        try (Connection conn = SQLiteConnection.Connector();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, birth);
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

}
