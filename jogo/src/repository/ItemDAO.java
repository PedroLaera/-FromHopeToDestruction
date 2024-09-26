//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Item;

public class ItemDAO {
    public ItemDAO() {
    }

    public static Item findItemByCenaId(int idCena, String nomeItem) throws SQLException {
        String sql = "SELECT * FROM itens_da_cena WHERE id_cena_atual = ? AND nome = ?";
        Connection conn = Mysql.getConnection();

        Item var7;
        label104: {
            Item item;
            try {
                PreparedStatement stmt;
                label106: {
                    stmt = conn.prepareStatement(sql);

                    try {
                        label107: {
                            stmt.setInt(1, idCena);
                            stmt.setString(2, nomeItem);
                            ResultSet rs = stmt.executeQuery();

                            label92: {
                                try {
                                    if (!rs.next()) {
                                        item = null;
                                        break label92;
                                    }

                                    item = new Item();
                                    item.setIdItem(rs.getInt("id"));
                                    item.setNome(rs.getString("nome"));
                                    item.setDescricaoPositiva(rs.getString("descricao_positiva"));
                                    item.setDescricaoNegativa(rs.getString("descricao_negativa"));
                                    item.setComandoCorreto(rs.getString("comando_correto"));
                                    item.setInteragivel(rs.getBoolean("interagivel"));
                                    item.setIdProximaCena(rs.getObject("id_cena_destino") != null ? rs.getInt("id_cena_destino") : null);
                                    var7 = item;
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
                                break label107;
                            }

                            if (rs != null) {
                                rs.close();
                            }
                            break label106;
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
                    break label104;
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

            return item;
        }

        if (conn != null) {
            conn.close();
        }

        return var7;
    }
}
