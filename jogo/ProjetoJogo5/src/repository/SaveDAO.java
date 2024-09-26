package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Cena;
import model.Save;

public class SaveDAO {

    public static void resetSaveToInitialState(int idSave) throws SQLException {
        Connection connection = Mysql.getConnection();
        String query = "UPDATE save SET id_cena_atual = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            int cenaInicialId = 1;
            statement.setInt(1, cenaInicialId);
            statement.setInt(2, idSave);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Nenhuma linha atualizada, talvez o ID do save esteja incorreto.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void atualizarCenaAtual(int idSave, int novoIdCena) throws SQLException {
        String query = "UPDATE save SET id_cena_atual = ? WHERE id = ?";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, novoIdCena);
            statement.setInt(2, idSave);
            statement.executeUpdate();
        }
    }


    public static Save findSaveById(int idSave) throws SQLException {
        String query = "SELECT * FROM save WHERE id = ?";
        Save save = null;

        try (Connection connection = Mysql.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idSave);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    save = new Save();
                    save.setIdSave(resultSet.getInt("id"));
                    int idCenaAtual = resultSet.getInt("id_cena_atual");
                    Cena cenaAtual = CenaDAO.findCenaById(idCenaAtual);
                    save.setCenaAtual(cenaAtual);
                }
            }
        }
        return save;
    }

        public static void updateIdCenaAtual(int idSave, int novoIdCena) throws SQLException {
            String query = "UPDATE save SET id_cena_atual = ? WHERE id = ?";
            try (Connection connection = Mysql.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, novoIdCena);
                statement.setInt(2, idSave);
                statement.executeUpdate();
            }
        }



    public static Save novoJogo() throws SQLException {
        Save save = new Save();
        int cenaInicialId = 1;


        String insertSave = "INSERT INTO save (id_cena_atual) VALUES (?)";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSave, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, cenaInicialId);

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idSave = generatedKeys.getInt(1);
                    save.setIdSave(idSave);
                    save.setCenaAtual(CenaDAO.findCenaById(1));
                    return save;
                }
            }
        }
        return save;
    }
}
