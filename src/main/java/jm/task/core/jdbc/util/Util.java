package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static Connection getConnection() {
        // реализуйте настройку соеденения с БД
        String PASS = "8RCDNjQUwpGg";
        String USER = "root";
        String URL = "jdbc:mysql://localhost:3306/kata";

        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
