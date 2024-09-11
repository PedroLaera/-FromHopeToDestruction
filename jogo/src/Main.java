import com.google.gson.Gson;
import model.Cena;
import model.Item;
import model.Save;
import repository.CenaDAO;
import repository.ItemDAO;
import repository.SaveDAO;
import spark.Spark;

import java.sql.SQLException;
import java.util.List;

import static spark.Spark.port;

public class Main {
    public static void main(String[] args) throws SQLException {

        Save save = SaveDAO.newGame();
        System.out.println(save.getCenaAtual().getDescricao());

        //Assistir aula do Jucelino do dia 10/09 aula 10
        //Implementar funcionalidade de cada comando









         //ligação com insomnia
//        Gson gson = new Gson();
//        port(3000);
//        try {
//            Cena cena = CenaDAO.findCenaById(1);
//            System.out.println(cena.toString());
//
//
//            List<Item> itens = ItemDAO.findItensByScene(cena);
//            System.out.println("Itens: " + itens);
//
//            Spark.get("/cena", (req,res) -> gson.toJson(itens));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


    }

    public static void selectUseObject() {
        System.out.println("Chamando comando de seleção de objeto ");
    }
}
