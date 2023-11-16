package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:src/database/academic_events.db";

    // Método para obter uma conexão com o banco de dados
    public static Connection connect() {
        try {
            // Registrando o driver JDBC para SQLite
            Class.forName("org.sqlite.JDBC");

            // Obtendo a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(URL);

            System.out.println("Conexão estabelecida com sucesso!");

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        Connection connection = DatabaseConnector.connect();

        // Faça operações no banco de dados aqui usando a conexão

        // Fechar a conexão quando terminar
        DatabaseConnector.closeConnection(connection);
    }
}