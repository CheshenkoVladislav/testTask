package com.testtask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private static String URL = "jdbc:mysql://localhost:3306/students"
            + "?verifyServerCertificate=false"
            + "&useSSL=false"
            + "&requireSSL=false"
            + "&useLegacyDatetimeCode=false"
            + "&amp"
            + "&serverTimezone=UTC";
    private static String LOGIN = "root";
    private static String PASSWORD = "root";

    Connection connection;

    public DBWorker(){
        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
