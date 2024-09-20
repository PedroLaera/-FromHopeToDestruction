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

    public boolean nextScene (int idCenaAtual, int idCenaSeguinte) throws SQLException {
        String sql = "update cena set id_cena = ? where id_cena = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jogo",
                "root",
                ""
        );
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCenaAtual);
            stmt.setInt(2, idCenaSeguinte);
            int rownAffected = stmt.executeUpdate();

            return rownAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }
}