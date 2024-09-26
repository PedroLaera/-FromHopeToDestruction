//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cena;
import model.Item;

public class CenaDAO {
    public static Cena findCenaById    (int id) throws SQLException {
        String sql = "SELECT * FROM cenas WHERE id= ?";
        Cena cena = null;


        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt( 1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cena = new Cena();
                    cena.setIdCena(rs.getInt(id));
                    cena.setDescricao(rs.getString("descricao"));
                }
            }
        }
        return cena;
    }

    public static List<Item> findItensByCenaId(Integer idCena) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM objetos WHERE id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idCena);
        ResultSet rs = stmt.executeQuery();
        List<Item> itens = new ArrayList();

        while(rs.next()) {
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            Item item = new Item();
            itens.add(item);
        }

        conn.close();
        return itens;
    }
}
