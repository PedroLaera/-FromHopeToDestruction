package repository;

import model.Cena;

import java.sql.*;

public class CenaDAO {

    public static Cena findCenaById(Integer id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "select * from cenas where id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Cena cena = new Cena();

        if (rs.next()){
            cena.setIdCena(rs.getInt("id_cena"));
            cena.setDescricao(rs.getString("descricao"));
            cena.setItens();
        }
        return cena;
    }
}