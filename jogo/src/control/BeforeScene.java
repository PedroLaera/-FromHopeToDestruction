//package control;
//
//import com.google.gson.Gson;
//import model.Console;
//import Comandos.Comandos;
//import spark.Request;
//import spark.Response;
//import spark.Route;
//
//
//public class BeforeScene implements Route {
//    private final Gson gson;
//    public BeforeScene(Gson gson) {
//        this.gson = gson;
//    }
//
//    @Override
//    public Object handle(Request request, Response response) throws Exception {
//        //Recebe um parâmetro da URI e guarda em uma variável
//        String comandoBruto = request.params(":comando");
//
//        //Instancia comando service passando o comando bruto como parâmetro do construtor.
//        Comandos comandoService = new Comandos(comandoBruto);
//
//        //O método getResultadoConsole retorna uma instância da classe Console.
//        Console console = comandoService.getResultadoConsole();
//
//        //Retornamos o objeto console convertido para Json.
//        return gson.toJson(console);
//    }
//}
