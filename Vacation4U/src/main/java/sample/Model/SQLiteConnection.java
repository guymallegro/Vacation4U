package sample.Model;

import java.sql.*;

public class SQLiteConnection {

    public static Connection Connector() {

        String url = "jdbc:sqlite:Vacation4uDB.db";

        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                createNewTable(url);
                System.out.println("Connected!");
                return conn;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static void createNewTable(String url) {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	username text PRIMARY KEY,\n"
                + "	password text NOT NULL,\n"
                + "	birth text real,\n"
                + "	firstName text NOT NULL,\n"
                + "	lastName text NOT NULL,\n"
                + "	city text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
