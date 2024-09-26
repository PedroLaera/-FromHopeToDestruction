package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Item;

public class InventarioDAO{
    public InventarioDAO(){
    }

    public static List<Item>getInventarioBySaveId(Integer idSave) throws SQLException{
        Connection conn=Mysql.getConnection();
        String sql = "SELECT*FROMinventarioWHEREid_save=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,idSave);
        ResultSet rs = stmt.executeQuery();
        List<Item>inventario= new ArrayList<>();

        while(rs.next()){
            String nomeItem=rs.getString("nome_item");
            String descricaoItem=rs.getString("descricao_item");
            Item item= new Item();
            inventario.add(item);
        }

        conn.close();
        return inventario;
    }

    public static void adicionarItemAoInventario(Item item,Integer idSave) throws SQLException{
        Connection conn = Mysql.getConnection();
        String sql = "INSERTINTOinventario(nome_item,descricao_item,id_save)VALUES(?,?,?)";
        PreparedStatement stmt =  conn.prepareStatement(sql);
        stmt.setString(1,item.getNome());
        stmt.setString(2,item.getDescricaoPositiva());
        stmt.setInt(3,idSave);
        stmt.executeUpdate();
        conn.close();
    }

    public static void removerItemDoInventario(String nomeItem,Integer idSave) throws SQLException{
        Connection conn = Mysql.getConnection();
        String sql = "DELETEFROMinventarioWHEREnome_item=?ANDid_save=?";
        PreparedStatement stmt =conn.prepareStatement(sql);
        stmt.setString(1,nomeItem);
        stmt.setInt(2,idSave);
        stmt.executeUpdate();
        conn.close();
    }
}
