package repository;

import model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class ItemDAO {

        public static Item findItemByCenaId(int idCena, String nomeItem) throws SQLException {
            String sql = "SELECT * FROM itens_da_cena WHERE id_cena_atual = ? AND nome = ?";

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
                        item.setIdProximaCena(rs.getObject("id_cena_destino") != null ? rs.getInt("id_cena_destino") : null);
                        return item;
                    } else {
                        return null;
                    }
                }
            }
        }
    }

