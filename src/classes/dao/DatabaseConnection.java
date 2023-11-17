package classes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static Connection con = null;
    static
    {
        String url = "jdbc:sqlite:src/database/academic_events.db";
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return con;
    }
}
