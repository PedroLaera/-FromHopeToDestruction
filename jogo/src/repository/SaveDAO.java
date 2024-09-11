package repository;

import com.mysql.cj.MysqlConnection;
import model.Save;

import java.sql.*;

public class SaveDAO {

    public static Save newGame() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql =  "insert into save (id_cena_atual) values (1)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();

        if (generatedKeys.next()) {
            save.setIdSave(generatedKeys.getInt(1));
            save.setCenaAtual(CenaDAO.findCenaById(1));
        }
        return save;

    }
}
