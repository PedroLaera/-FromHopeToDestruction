import model.Cena;
import model.Item;
import repository.CenaDAO;
import repository.ItemDAO;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Cena cena = CenaDAO.findCenaById(1);
            System.out.println(cena.toString());


            List<Item> itens = ItemDAO.findItensByScene(cena);
            System.out.println("Itens: " + itens);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
