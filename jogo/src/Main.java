import com.google.gson.Gson;
import control.BeforeScene;
import control.CurrentScene;
import spark.Spark;

import java.sql.SQLException;

private static final Gson gson = new Gson();

public static void main(String[] args) throws SQLException {

//    //Na classe main deixamos apenas as rotas da API
//    //controller -> É responsável por tratar as requisições e respostas http
//    //service -> É responsável pela lógica e regra de negócio da aplicação.
//    //model -> É responsável por definir os atributos e métodos das entidades do projeto.
//    //repository -> É responsável pela comunicação com o banco de dados.
//
//    //Rota 1 http://localhost:4567/{o comando vai aqui}
//    Spark.get("/:comando",new BeforeScene(gson));
//
//    //Rota 2 http://localhost:4567/{comando}/{save}
//    Spark.get("/:comando/:save", new CurrentScene(gson));

}






























//        //Assistir aula do Jucelino do dia 10/09 aula 10
//        //Implementar funcionalidade de cada comando
//        Cena cena = CenaDAO.findCenaById(1);
//        System.out.println(cena);
//
//    }
//    public static void selectUseObject() {
//        System.out.println("Chamando comando de seleção de objeto ");
//    }
//

//
//ligação com insomnia
//Gson gson = new Gson();
//port(3306);
//        try {
//Cena cena = CenaDAO.findCenaById(1);
//            System.out.println(cena.toString());
//
//List<Item> itens = ItemDAO.findItensByScene(cena);
//            System.out.println("Itens: " + itens);
//
//            Spark.get("/cena", (req,res) -> gson.toJson(itens));
//        } catch (
//SQLException e) {
//        throw new RuntimeException(e);
////        }