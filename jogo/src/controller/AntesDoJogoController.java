//package controller;
//
//import Comandos.Comandos;
//import com.google.gson.Gson;
//import model.Console;
//import service.ComandoStart;
//import spark.Request;
//import spark.Response;
//import spark.Route;
//
//
//public class AntesDoJogoController implements Route {
//    private final Gson gson;
//    public AntesDoJogoController(Gson gson) {
//        this.gson = gson;
//    }
//
//    @Override
//    public Object handle(Request request, Response response) throws Exception {
//        //Recebe um parâmetro da URI e guarda em uma variável
//        String comandoBruto = request.params(":comando");
//
//        //Instancia comando service passando o comando bruto como parâmetro do construtor.
//        Comandos comandoService = new Comandos();
//
//        //O método getResultadoConsole retorna uma instância da classe Console.
////        Console console = comandoService.executarComandos();
//
//        //Retornamos o objeto console convertido para Json.
//        return gson.toJson(console);
//    }
//}