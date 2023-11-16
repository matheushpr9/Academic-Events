import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnector;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
		Connection conn = DatabaseConnector.connect();
		Statement statement = conn.createStatement();
		statement.setQueryTimeout(30); 
		ResultSet rs = statement.executeQuery("SELECT * FROM author");
		while(rs.next()) {
			// Ler os dados inseridos
			System.out.println("NOME DO CARA  : " + rs.getString("name"));
		}
    }
}
