package Pertemuan6.Complex;

import java.sql.*;

public class Database {

    private static final String dbName = "fedosdb", dbUsername = "root", dbPass = "";

    public Statement makeStatement() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + dbName,
                dbUsername,
                dbPass
        );
        return connection.createStatement();
    }
}
