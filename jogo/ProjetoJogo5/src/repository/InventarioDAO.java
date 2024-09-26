package repository;

import model.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Item;

public class InventarioDAO {

    public static Item findItemByCenaId(int idCena, String nomeItem) throws SQLException {
        String sql = "SELECT * FROM itens_da_cena WHERE cena_id = ? AND nome = ?"; // Use o nome correto da coluna

        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCena);
            stmt.setString(2, nomeItem);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Item item = new Item();
                    item.setIdItem(rs.getInt("id"));
                    item.setNome(rs.getString("nome"));
                    item.setDescricaoPositiva(rs.getString("descricao_positiva"));
                    item.setDescricaoNegativa(rs.getString("descricao_negativa"));
                    item.setComandoCorreto(rs.getString("comando_correto"));
                    item.setInteragivel(rs.getBoolean("interagivel"));
                    item.setIdProximaCena(rs.getObject("id_proxima_cena") != null ? rs.getInt("id_proxima_cena") : null);
                    return item;
                } else {
                    return null;
                }
            }
        }
    }


    public static List<Inventario> findAllInventarios() throws SQLException {
        List<Inventario> inventarios = new ArrayList<>();
        String query = "SELECT * FROM itens_de_inventario";

        try (Connection connection = Mysql.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Inventario inventario = new Inventario();
                inventario.setIdInventario(resultSet.getInt("id"));
                inventario.setNomeItem(resultSet.getString("nome_item"));
                inventario.setDescricao(resultSet.getString("descricao"));
                inventario.setId_save(resultSet.getInt("id_save"));
                inventarios.add(inventario);
            }
        }
        return inventarios;
    }

    public static void clearInventarioBySaveId(int idSave) throws SQLException {
        String query = "DELETE FROM itens_de_inventario WHERE id_save = ?";

        try (Connection connection = Mysql.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idSave);
            statement.executeUpdate();
        }
    }

    public static List<Inventario> findInventariosBySaveId(String itemInventarioNome) throws SQLException {
        List<Inventario> inventarios = new ArrayList<>();
        String query = "SELECT * FROM itens_de_inventario WHERE nome_item = ?";

        try (Connection connection = Mysql.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, itemInventarioNome);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Inventario inventario = new Inventario();
                    inventario.setIdInventario(resultSet.getInt("id"));
                    inventario.setNomeItem(resultSet.getString("nome_jogador"));
                    inventario.setDescricao(resultSet.getString("nome"));
                    inventario.setId_save(resultSet.getInt("descricao"));
                    inventarios.add(inventario);
                }
            }
        }
        return inventarios;
    }

    public static void insertInventario(Inventario inventario) throws SQLException {
        String insert = "INSERT INTO inventario (id, nome_jogador, nome, descricao) VALUES (?, ?, ?, ?)";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement statement = connection.prepareStatement(insert)) {
            statement.setString(1, inventario.getNomeItem());
            statement.setString(2, inventario.getDescricao());
            statement.setInt(3, inventario.getId_save());
            statement.executeUpdate();
        }
    }
}
