


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Save;
import repository.Mysql;

public class SaveDAO{
    public SaveDAO(){
    }

    public static SaveDAO staticSavefindSaveById (Integer idSave) throws SQLException {
        Connection conn= Mysql.getConnection();
        String sql =" SELECT * FROM save WHERE id_save = ? ";
        PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        ResultSet rs = stmt.executeQuery();
        Save save = null;
        if(rs.next()){
            int idCenaAtual = rs.getInt("id_cena_atual");
            SaveDAO saveDAO =
        }

        conn.close();
        return Save;
    }

    public static void newSave(Integer idSave ,Integer idCenaAtual)throws SQLException{
        Connection conn = Mysql.getConnection();
        String sql ="INSERTINTOsave(id_save,id_cena_atual)VALUES(?,?)";
        PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setInt(1,idSave);
        stmt.setInt(2,idCenaAtual);
        stmt.executeUpdate();
        conn.close();
    }
}
