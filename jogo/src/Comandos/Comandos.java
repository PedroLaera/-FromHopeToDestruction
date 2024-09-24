package Comandos;

import model.Cena;
import model.Console;
import model.Save;
import repository.CenaDAO;
import repository.SaveDAO;

import java.sql.SQLException;

public class Comandos {
    private final String[] comando;
    private final Console console;

    public Comandos(String comandoBruto){
        Console console = new Console();
        this.console = console;
        this.comando = comandoBruto.split(" ");

    }
    //----------------------------------------------------------------------- COMANDO HELP
    public Console help() {
        console.setMensagem("Este aqui é o texto de ajuda");
        return console;
    }
    //----------------------------------------------------------------------- COMANDO START
    public Console start() {
        try {
            Save save = SaveDAO.newGame();
            console.setMensagem(save.getCenaAtual().getDescricao());
            console.setIdSave(save.getIdSave());
            return console;
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao tentar iniciar o jogo");
            return console;
        }
    }
//--------------------------------------------------------------------------- COMANDO OPEN

    public Console open (String comando) {
        try {
            // Verifica se o comando começa com "open"
            if (comando.startsWith("open ")) {
                String objeto = comando.substring(5); // Remove "open " para obter o objeto
                return abrirObjeto(objeto);
            } else {
                console.setMensagem("Comando não reconhecido. Tente novamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao processar o comando");
        }
        return console;
    }

    private Console abrirObjeto(String objeto) throws SQLException {
        switch (objeto) {
            case "gaveta":
                console.setMensagem("Você abriu a gaveta. Dentro há um papel.");
                CenaDAO.findCenaById();  // Avança para a próxima cena
                atualizarCena(); // Atualiza a descrição da nova cena
                break;
            case "terminal":
                console.setMensagem("Você acessou o terminal. Pronto para digitar comandos.");
                CenaDAO.findCenaById();  // Avança para a próxima cena
                atualizarCena(); // Atualiza a descrição da nova cena
                break;
            case "areaTrabalho":
                console.setMensagem("Você olhou para a área de trabalho. Está organizada.");
                CenaDAO.findCenaById();  // Avança para a próxima cena
                atualizarCena(); // Atualiza a descrição da nova cena
                break;
            case "app":
                console.setMensagem("Você abriu o aplicativo. O que deseja fazer?");
                CenaDAO.findCenaById();  // Avança para a próxima cena
                atualizarCena(); // Atualiza a descrição da nova cena
                break;
            default:
                console.setMensagem("Objeto não reconhecido.");
                break;
        }
        return console;
    }

//--------------------------------------------------------------------------- COMANDO SELECT

    private Console select (String objeto) throws SQLException {
        switch (objeto) {
            case "tomada":
                console.setMensagem("Você selecionou a tomada. A energia está ligada.");
                CenaDAO.findCenaById();  // Avança para a próxima cena
                atualizarCena(); // Atualiza a descrição da nova cena
                break;
            case "morte":
                console.setMensagem("Você selecionou a morte. Uma visão sombria aparece.");
                CenaDAO.findCenaById();  // Avança para a próxima cena
                atualizarCena(); // Atualiza a descrição da nova cena
                break;
            default:
                console.setMensagem("Objeto não reconhecido.");
                break;
        }
        return console;
    }

//--------------------------------------------------------------------------- COMANDO ON

    private Console on (String comando) {
        try {
            if (comando.startsWith("on ")) {
                String objeto = comando.substring(3);
                return ligarObjeto(objeto);
            } else {
                console.setMensagem("Comando não reconhecido. Tente novamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao processar o comando");
        }
        return console;
    }

    private Console ligarObjeto(String objeto) throws SQLException {
        if ("computer".equals(objeto)) {
            console.setMensagem("Você ligou o computador. A tela acende.");
            CenaDAO.findCenaById();  // Avança para a próxima cena
            atualizarCena(); // Atualiza a descrição da nova cena
        } else {
            console.setMensagem("Objeto não reconhecido. Tente 'on computer'.");
        }
        return console;
    }

//--------------------------------------------------------------------------- COMANDO CUT

    private Console cut (String comando) {
        try {
            if (comando.startsWith("cut ")) {
                String objeto = comando.substring(4);
                return cortarObjeto(objeto);
            } else {
                console.setMensagem("Comando não reconhecido. Tente novamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao processar o comando");
        }
        return console;
    }

    private Console cortarObjeto(String objeto) throws SQLException {
        if ("amarelo".equals(objeto)) {
            console.setMensagem("Você cortou o objeto amarelo. Ele se desfaz em pedaços.");
            CenaDAO.findCenaById();  // Avança para a próxima cena
            atualizarCena(); // Atualiza a descrição da nova cena
        } else {
            console.setMensagem("Objeto não reconhecido. Tente 'cut amarelo'.");
        }
        return console;
    }

//--------------------------------------------------------------------------- COMANDO KEY

    private Console key (String comando, int CenaDAO) {
        try {
            if (comando.equals("key = 0")) {
                return usarChaveZero();
            } else if (comando.equals("key = morte")) {
                return usarChaveMorte();
            } else {
                console.setMensagem("Comando não reconhecido. Tente novamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao processar o comando");
        }
        return console;
    }

    private Console usarChaveZero() throws SQLException {
        if (CenaDAO.findCenaById()) {
            console.setMensagem("Você usou a chave 0. A porta se abre.");
            try {
                CenaDAO.findCenaById();  // Avança para a próxima cena (de 11 para 12)
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            console.setMensagem("Você não pode usar a chave 0 agora.");
        }
        return console;
    }

    private Console usarChaveMorte() throws SQLException {
        if (CenaDAO.findCenaById()) {
            console.setMensagem("Você usou a chave 'morte'. Uma passagem secreta se revela.");
            CenaDAO.findCenaById();  // Avança para a próxima cena (de 14 para 15)
            atualizarCena(); // Atualiza a descrição da nova cena
        } else {
            console.setMensagem("Você não pode usar a chave 'morte' agora.");
        }
        return console;
    }

//--------------------------------------------------------------------------- COMANDO NEXT

    private Console next (String comando) {
        try {
            if (comando.equals("next")) {
                return proximoCenario();
            } else {
                console.setMensagem("Comando não reconhecido. Tente novamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao processar o comando");
        }
        return console;
    }

    private Console proximoCenario() throws SQLException {
        if (CenaDAO.findCenaById()) {
            console.setMensagem("Fim de jogo.");  // Mensagem ao finalizar
            CenaDAO.findCenaById();  // Reinicia o jogo, voltando para a cena 1
        } else {
            console.setMensagem("Você não pode pular para a próxima cena agora.");
        }
        return console;
    }

//_________________________________________________________________________ A T U A L I Z A    A S    C E N A S

    private void atualizarCena() {
        try {
            boolean cenaAtual = CenaDAO.findCenaById();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (comando != null) {
           console.setMensagem(Cena.getDescricao());
        } else {
           console.setMensagem("Cena não encontrada.");
        }
}

//___________________________________________________________________________________________
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














































//----------------------------------------------------------------------------------------------------------------------

//package Comandos;
//import repository.CenaDAO;
//import java.io.Console;
//import java.sql.SQLException;
//import model.Cena;
//import model.Item;
//import model.Save;
//import repository.ItemDAO;
//import repository.SaveDAO;
//import model.Console;
//import java.util.List;
//
//public class Comandos {
//    private final String[] comando;
//    private final Console console;
//
//    public Comandos(String comandoBruto){
//        Console console = new Console();
//        this.console = console;
//        this.comando = comandoBruto.split(" "); // help / use faquinha / check banana
//
//        if ("help".equals(this.comando[0])) {
//            this.help();
//        } else if ("use".equals(this.comando[0])) {
//            this.use();
//        }
//    }
//
//    private void use() {
//        try {
//            Cena cena = CenaDAO.findCenaById(1);
//
//            List<Item> itens = ItemDAO.findItensByScene(cena);
//
//            String nomeItem = this.comando[1];
//            for (Item item : itens) {
//                if (item.getNome().equals(nomeItem)) {
//                }
//            }
//            // use chave with porta
//            if (this.comando[2] != null && "with".equals(this.comando[2])) {
//                String nomeItem2 = this.comando[3];
//                for (Item item : itens) {
//                    if (item.getNome().equals(nomeItem)) {
//                    }
//                }
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void open() {
//        try {
//            Cena cena = CenaDAO.findCenaById(1);
//
//            List<Item> itens = ItemDAO.findItensByScene(cena);
//            String nomeItem = this.comando[1];
//            for (Item item : itens) {
//                if (item.getNome().equals(nomeItem)) {
//                }
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    public Console help() {
//        console.printf("Este aqui é o texto de ajuda");
//        return console;
//    }
//
//    public Console start() {
//        try {
//            Save save = SaveDAO.newGame();
//            console.setMensagem(save.getCenaAtual().getDescricao());
//            console.setIdSave(save.getIdSave());
//            return console;
//        } catch (Exception e) {
//            e.printStackTrace();
//            console.setMensagem("Erro ao tentar iniciar o jogo");
//            return console;
//        }
//    }
//
//    public Console getResultadoConsole(){
//        try {
//            //A variável primeiroComando recebe a primeira posição
//            //do array comando.
//            String primeiroComando = comando[0].toLowerCase();
//
//            //O comando switch irá testar o nome do primeiro comando.
//            //se o valor da variável for igual ao da sentença case
//            //iremos chamar o método para tratar sobre aquele comando.
//            return switch (primeiroComando) {
//                case "help" -> help();
//                case "start" -> start();
//                default -> {
//                    console.setMensagem("Comando inválido");
//                    yield console;
//                }
//            };
//        } catch (Exception e) {
//            console.setMensagem("Comando inválido");
//            return console;
//        }
//    }
//}




//------------------------------------------------------------------  T E S T E S ------------------------------------------------------------------------

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