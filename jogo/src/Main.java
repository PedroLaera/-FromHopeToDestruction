
import Comandos.Comandos;
import model.Console;
import service.ComandoCheck;
import service.ComandoGet;
import service.ComandoHelp;
import service.ComandoInventory;
import service.ComandoLoad;
import service.ComandoRestart;
import service.ComandoStart;
import service.ComandoUse;
import com.google.gson.Gson;
//import controller.AntesDoJogoController;
//import controller.DuranteOJogoController;
import spark.Spark;



public static void main(String[] args) {

    }
        public class Main {
            public static void main(String[] args) {
                Comandos comandos = new Comandos();
                comandos.executarComandos();
            }
}


