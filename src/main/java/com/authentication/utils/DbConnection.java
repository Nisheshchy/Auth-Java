package com.authentication.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    private static final String URL="jdbc:mysql://localhost:3306/learninglogs";
    private static final String USER="root";
    private static final String PASS="Nishesh~";
    private static boolean initialized = false;

    public static synchronized Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (!initialized) {
            initializeDatabase();
            initialized = true;
        }

        return DriverManager.getConnection(URL,USER,PASS);
    }

    private static void initializeDatabase() {
        String baseUrl = "jdbc:mysql://localhost:3306/";
        try (Connection conn = DriverManager.getConnection(baseUrl, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS learninglogs");
            System.out.println("Database 'learninglogs' verified/created.");
        } catch (SQLException e) {
            System.err.println("Warning: Could not verify/create database 'learninglogs': " + e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS user (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) UNIQUE NOT NULL," +
                    "password VARCHAR(255) NOT NULL" +
                    ")");
            System.out.println("Table 'user' verified/created.");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS topic (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "createdAt TIMESTAMP NOT NULL," +
                    "updatedAt TIMESTAMP NULL DEFAULT NULL" +
                    ")");
            System.out.println("Table 'topic' verified/created.");
        } catch (SQLException e) {
            System.err.println("Warning: Could not verify/create tables: " + e.getMessage());
        }
    }
}
