package com.coforge.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/product"; // change DB if needed
    private static final String USER = "root";                              // change
    private static final String PASS = "cfg@1234";                              // change

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // For MySQL Connector/J 8+, the driver is com.mysql.cj.jdbc.Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
