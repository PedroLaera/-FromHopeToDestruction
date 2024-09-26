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
import model.Save;

public class SaveDAO {
    public SaveDAO() {
    }

    public static void resetSaveToInitialState(int idSave) throws SQLException {
        Connection connection = Mysql.getConnection();
        String query = "UPDATE save SET id_cena_atual = ? WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            try {
                int cenaInicialId = 1;
                statement.setInt(1, cenaInicialId);
                statement.setInt(2, idSave);
                int affectedRows = statement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Nenhuma linha atualizada, talvez o ID do save esteja incorreto.");
                }
            } catch (Throwable var7) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (statement != null) {
                statement.close();
            }

        } catch (SQLException var8) {
            SQLException e = var8;
            e.printStackTrace();
            throw e;
        }
    }

    public static void atualizarCenaAtual(int idSave, int novoIdCena) throws SQLException {
        String query = "UPDATE save SET id_cena_atual = ? WHERE id = ?";
        Connection connection = Mysql.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            try {
                statement.setInt(1, novoIdCena);
                statement.setInt(2, idSave);
                statement.executeUpdate();
            } catch (Throwable var9) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Throwable var10) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var7) {
                    var10.addSuppressed(var7);
                }
            }

            throw var10;
        }

        if (connection != null) {
            connection.close();
        }

    }

    public static Save findSaveById(int idSave) throws SQLException {
        String query = "SELECT * FROM save WHERE id = ?";
        Save save = null;
        Connection connection = Mysql.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            try {
                statement.setInt(1, idSave);
                ResultSet resultSet = statement.executeQuery();

                try {
                    if (resultSet.next()) {
                        save = new Save();
                        save.setIdSave(resultSet.getInt("id"));
                        int idCenaAtual = resultSet.getInt("id_cena_atual");
                        Cena cenaAtual = CenaDAO.findCenaById(idCenaAtual);
                        save.setCenaAtual(cenaAtual);
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

        return save;
    }

    public static void updateIdCenaAtual(int idSave, int novoIdCena) throws SQLException {
        String query = "UPDATE save SET id_cena_atual = ? WHERE id = ?";
        Connection connection = Mysql.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            try {
                statement.setInt(1, novoIdCena);
                statement.setInt(2, idSave);
                statement.executeUpdate();
            } catch (Throwable var9) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Throwable var10) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var7) {
                    var10.addSuppressed(var7);
                }
            }

            throw var10;
        }

        if (connection != null) {
            connection.close();
        }

    }

    public static Save novoJogo() throws SQLException {
        Save save = new Save();
        int cenaInicialId = 1;
        String insertSave = "INSERT INTO save (id_cena_atual) VALUES (?)";
        Connection connection = Mysql.getConnection();

        Save var7;
        label95: {
            try {
                PreparedStatement statement;
                label97: {
                    statement = connection.prepareStatement(insertSave, 1);

                    try {
                        statement.setInt(1, cenaInicialId);
                        statement.executeUpdate();
                        ResultSet generatedKeys = statement.getGeneratedKeys();

                        label83: {
                            try {
                                if (generatedKeys.next()) {
                                    int idSave = generatedKeys.getInt(1);
                                    save.setIdSave(idSave);
                                    save.setCenaAtual(CenaDAO.findCenaById(1));
                                    var7 = save;
                                    break label83;
                                }
                            } catch (Throwable var11) {
                                if (generatedKeys != null) {
                                    try {
                                        generatedKeys.close();
                                    } catch (Throwable var10) {
                                        var11.addSuppressed(var10);
                                    }
                                }

                                throw var11;
                            }

                            if (generatedKeys != null) {
                                generatedKeys.close();
                            }
                            break label97;
                        }

                        if (generatedKeys != null) {
                            generatedKeys.close();
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
                    break label95;
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

            return save;
        }

        if (connection != null) {
            connection.close();
        }

        return var7;
    }
}
