package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import static java.lang.Class.forName;

public class Mysql {
    public static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jogo",
                    "root",
                    ""
            );
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar com o banco de dados...");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao tentar importar o driver do banco de dados...");
        } return null;
    }
}