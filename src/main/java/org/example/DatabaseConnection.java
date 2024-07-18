package org.example;
import java.sql.*;

public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String user = "postgres";
    private static final String password = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
