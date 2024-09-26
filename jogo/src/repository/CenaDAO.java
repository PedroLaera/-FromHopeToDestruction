//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cena;

public class CenaDAO {
    public CenaDAO() {
    }

    public static Cena findCenaById(int id) throws SQLException {
        String sql = "SELECT * FROM cenas WHERE id = ?";
        Cena cena = null;
        Connection conn = Mysql.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                try {
                    if (rs.next()) {
                        cena = new Cena();
                        cena.setId(rs.getInt("id"));
                        cena.setDescricao(rs.getString("descricao"));
                    }
                } catch (Throwable var11) {
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Throwable var12) {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (stmt != null) {
                stmt.close();
            }
        } catch (Throwable var13) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable var8) {
                    var13.addSuppressed(var8);
                }
            }

            throw var13;
        }

        if (conn != null) {
            conn.close();
        }

        return cena;
    }

    public static void insertCena(Cena cena) throws SQLException {
        String insert = "INSERT INTO cenas(descricao) VALUES (?);";
        Connection conn = Mysql.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(insert);

            try {
                ps.setString(1, cena.getDescricao());
                ps.executeUpdate();
            } catch (Throwable var8) {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (ps != null) {
                ps.close();
            }
        } catch (Throwable var9) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable var6) {
                    var9.addSuppressed(var6);
                }
            }

            throw var9;
        }

        if (conn != null) {
            conn.close();
        }

    }
}
