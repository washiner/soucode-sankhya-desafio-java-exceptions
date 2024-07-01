import java.sql.SQLException;

public class Exercicio02 {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/soulcodedb";
        String user = "admin";
        String password = "admin123";

        try {
            simulateDatabaseConnection(url, user, password);
        } catch (DatabaseConnectionException e) {
            System.err.println("Erro: Falha ao conectar com o banco de dados");
        }

        try {
            simulateSQLQuery();
        } catch (SQLQueryException e) {
            System.err.println("Erro: Falha ao executar a consulta SQL");
        }
    }

    public static void simulateDatabaseConnection(String url, String user, String password) {
        try {
            // Simula uma exceção de conexão
            throw new SQLException("Simulação de falha na conexão");
        } catch (SQLException e) {
            throw new DatabaseConnectionException();
        }
    }

    public static void simulateSQLQuery() {
        try {
            throw new SQLException("Simulação de falha na consulta SQL");
        } catch (SQLException e) {
            throw new SQLQueryException();
        }
    }

    public static class DatabaseConnectionException extends RuntimeException {
    }

    public static class SQLQueryException extends RuntimeException {
    }
}
