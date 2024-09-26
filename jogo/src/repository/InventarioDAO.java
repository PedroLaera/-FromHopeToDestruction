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
import model.Inventario;
import model.Item;

public class InventarioDAO {
    public InventarioDAO() {
    }

    public static Item findItemByCenaId(int idCena, String nomeItem) throws SQLException {
        String sql = "SELECT * FROM itens_da_cena WHERE cena_id = ? AND nome = ?";
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
                                    item.setIdProximaCena(rs.getObject("id_proxima_cena") != null ? rs.getInt("id_proxima_cena") : null);
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

    public static List<Inventario> findAllInventarios() throws SQLException {
        List<Inventario> inventarios = new ArrayList();
        String query = "SELECT * FROM itens_de_inventario";
        Connection connection = Mysql.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            try {
                ResultSet resultSet = statement.executeQuery();

                try {
                    while(resultSet.next()) {
                        Inventario inventario = new Inventario();
                        inventario.setIdInventario(resultSet.getInt("id"));
                        inventario.setNomeItem(resultSet.getString("nome_item"));
                        inventario.setDescricao(resultSet.getString("descricao"));
                        inventario.setId_save(resultSet.getInt("id_save"));
                        inventarios.add(inventario);
                    }
                } catch (Throwable var10) {
                    if (resultSet != null) {
                        try {
                            resultSet.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Throwable var11) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Throwable var12) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var7) {
                    var12.addSuppressed(var7);
                }
            }

            throw var12;
        }

        if (connection != null) {
            connection.close();
        }

        return inventarios;
    }

    public static void clearInventarioBySaveId(int idSave) throws SQLException {
        String query = "DELETE FROM itens_de_inventario WHERE id_save = ?";
        Connection connection = Mysql.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            try {
                statement.setInt(1, idSave);
                statement.executeUpdate();
            } catch (Throwable var8) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Throwable var9) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var6) {
                    var9.addSuppressed(var6);
                }
            }

            throw var9;
        }

        if (connection != null) {
            connection.close();
        }

    }

    public static List<Inventario> findInventariosBySaveId(String itemInventarioNome) throws SQLException {
        List<Inventario> inventarios = new ArrayList();
        String query = "SELECT * FROM itens_de_inventario WHERE nome_item = ?";
        Connection connection = Mysql.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            try {
                statement.setString(1, itemInventarioNome);
                ResultSet resultSet = statement.executeQuery();

                try {
                    while(resultSet.next()) {
                        Inventario inventario = new Inventario();
                        inventario.setIdInventario(resultSet.getInt("id"));
                        inventario.setNomeItem(resultSet.getString("nome_jogador"));
                        inventario.setDescricao(resultSet.getString("nome"));
                        inventario.setId_save(resultSet.getInt("descricao"));
                        inventarios.add(inventario);
                    }
                } catch (Throwable var11) {
                    if (resultSet != null) {
                        try {
                            resultSet.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Throwable var12) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Throwable var13) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var8) {
                    var13.addSuppressed(var8);
                }
            }

            throw var13;
        }

        if (connection != null) {
            connection.close();
        }

        return inventarios;
    }

    public static void insertInventario(Inventario inventario) throws SQLException {
        String insert = "INSERT INTO inventario (id, nome_jogador, nome, descricao) VALUES (?, ?, ?, ?)";
        Connection connection = Mysql.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insert);

            try {
                statement.setString(1, inventario.getNomeItem());
                statement.setString(2, inventario.getDescricao());
                statement.setInt(3, inventario.getId_save());
                statement.executeUpdate();
            } catch (Throwable var8) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Throwable var9) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var6) {
                    var9.addSuppressed(var6);
                }
            }

            throw var9;
        }

        if (connection != null) {
            connection.close();
        }

    }
}
