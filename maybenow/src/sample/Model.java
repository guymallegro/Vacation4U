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
}
