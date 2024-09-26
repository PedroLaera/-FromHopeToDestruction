import java.sql.SQLException;
import java.util.Scanner;
import Comandos.Comandos;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Text Adventure Game!");
        System.out.println("Digite 'help' para ver os comandos disponíveis.");

        String comando;
        do {
            System.out.print("> ");
            comando = scanner.nextLine();

            try {
                Comandos comandoService = new Comandos(comando);
                comandoService.processarComando();
            } catch (SQLException var4) {
                SQLException e = var4;
                System.out.println("Erro ao processar o comando: " + e.getMessage());
            }
        } while(!comando.equalsIgnoreCase("exit"));

        System.out.println("Saindo do jogo...");
        scanner.close();
    }
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