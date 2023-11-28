package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static final String URL = "jdbc:sqlite:src/database/academic_events.db";
    private static Connection instance = null;

    private DatabaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            instance = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        if (instance == null) {
            new DatabaseConnection();
        }
        return instance;
    }
}
