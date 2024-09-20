package Comandos;

import repository.CenaDAO;

import java.io.Console;
import java.sql.SQLException;
import java.util.logging.ConsoleHandler;

package Comandos;

import model.Cena;
import model.Console;
import model.Item;
import model.Save;
import repository.CenaDAO;
import repository.ItemDAO;
import repository.SaveDAO;
import java.sql.SQLException;
import java.util.List;

import static sun.net.InetAddressCachePolicy.get;

public class ComandoService {
    private final String[] comando;
    private final Console console;

    public ComandoService(String comandoBruto){
        Console console = new Console();
        this.console = console;
        this.comando = comandoBruto.split(" "); // help / use faquinha / check banana

        if ("help".equals(this.comando[0])) {
            this.help();
        } else if ("use".equals(this.comando[0])) {
            this.use();
        }
    }

    private void use() {
        try {
            Cena cena = CenaDAO.findCenaById(1);

            List<Item> itens = ItemDAO.findItensByScene(cena);

            String nomeItem = this.comando[1];
            for (Item item : itens) {
                if (item.getNome().equals(nomeItem)) {
                }
            }
            // use chave with porta
            if (this.comando[2] != null && "with".equals(this.comando[2])) {
                String nomeItem2 = this.comando[3];
                for (Item item : itens) {
                    if (item.getNome().equals(nomeItem)) {
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Console help() {
        console.setMensagem("Este aqui é o texto de ajuda");
        return console;
    }

    public Console start() {
        try {
            Save save = SaveDAO.novoJogo();
            console.setMensagem(save.getCenaAtual().getDescricao());
            console.setIdSave(save.getIdSave());
            return console;
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao tentar iniciar o jogo");
            return console;
        }
    }

    public Console getResultadoConsole(){
        try {
            //A variável primeiroComando recebe a primeira posição
            //do array comando.
            String primeiroComando = comando[0].toLowerCase();

            //O comando switch irá testar o nome do primeiro comando.
            //se o valor da variável for igual ao da sentença case
            //iremos chamar o método para tratar sobre aquele comando.
            return switch (primeiroComando) {
                case "help" -> help();
                case "start" -> start();
                default -> {
                    console.setMensagem("Comando inválido");
                    yield console;
                }
            };
        } catch (Exception e) {
            console.setMensagem("Comando inválido");
            return console;
        }
    }
}




//------------------------------------------------------------------  T E S T E S -----------------------------

//public class Comandos {
//    private final String[] comando;
//    private final Console console;
//
//    public Comandos(String comandoBruto) {
//        Console console = new Console();
//        this.console = console;
//        this.comando = comandoBruto.split(" "); // usado para separar os comandos, como "get + espaço = comando"
//
//        if ("help".equals(this.comando[0])) {
//            this.help();
//        } else if ("use".equals(this.comando[0])){
//            this.use();
//        } else if ("on".equals(this.comando[0])) {
//            this.on();
//        } else if ("open".equals(this.comando[0]){
//            this.open();
//        } else if ("select".equals(this.comando[0])) {
//            this.select();
//        } else if ()