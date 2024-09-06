import com.google.gson.Gson;
import model.Cena;
import model.Item;
import repository.CenaDAO;
import repository.ItemDAO;
import spark.Spark;

import java.sql.SQLException;
import java.util.List;

import static spark.Spark.port;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        port(3000);
        try {
            Cena cena = CenaDAO.findCenaById(1);
            System.out.println(cena.toString());


            List<Item> itens = ItemDAO.findItensByScene(cena);
            System.out.println("Itens: " + itens);

            Spark.get("/cena", (req,res) -> gson.toJson(itens));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
