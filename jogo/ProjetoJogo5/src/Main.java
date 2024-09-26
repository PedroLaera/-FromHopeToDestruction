import model.Console;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ComandoHelp comandoHelp = new ComandoHelp();
        ComandoStart comandoStart = new ComandoStart();
        ComandoUse comandoUse = new ComandoUse();
        ComandoGet comandoGet = new ComandoGet();
        ComandoInventory comandoInventory = new ComandoInventory();
        ComandoCheck comandoCheck = new ComandoCheck();
        ComandoLoad comandoLoad = new ComandoLoad();
        ComandoRestart comandoRestart = new ComandoRestart();

        System.out.println("Bem-vindo ao jogo!");
        Console console = comandoStart.executar().get(0);
        System.out.println(console.getMensagem());
        int idSave = console.getIdSave();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+");

            if (parts.length == 0 || parts[0].isEmpty()) {
                System.out.println("Por favor, insira um comando. Digite HELP para ver os comandos disponíveis.");
                continue;
            }

            String comando = parts[0].toUpperCase();

            switch (comando) {
                case "HELP":
                    System.out.println(comandoHelp.executar());
                    break;
                case "CHECK":
                    if (parts.length > 1) {
                        String nomeItem = parts[1];
                        System.out.println(comandoCheck.executar(nomeItem, idSave).getMensagem());
                    } else {
                        System.out.println("Por favor, especifique o item a ser verificado.");
                    }
                    break;
                case "GET":
                    if (parts.length > 1) {
                        String nomeItem = parts[1];
                        System.out.println(comandoGet.executar(nomeItem, idSave).getMensagem());
                    } else {
                        System.out.println("Por favor, especifique o item a ser pego.");
                    }
                    break;
                case "INVENTORY":
                    System.out.println(comandoInventory.executar(idSave).getMensagem());
                    break;
                case "USE":
                    if (parts.length > 3 && parts[2].equalsIgnoreCase("WITH")) {
                        String itemInventarioNome = parts[1];
                        String itemCenaNome = parts[3];
                        System.out.println(comandoUse.executar(itemInventarioNome, idSave).getMensagem());
                    } else if (parts.length > 1) {
                        String itemNome = parts[1];
                        System.out.println(comandoUse.executar(itemNome, idSave).getMensagem());
                    } else {
                        System.out.println("Por favor, especifique o item a ser usado.");
                    }
                    break;
                case "RESTART":
                    System.out.println(comandoRestart.executar(idSave).getMensagem());
                    break;
                case "SAVE":
                    System.out.println("esse tbm nao foi dessa vez");
                    break;
                case "LOAD":
                    System.out.println("nao deu pra fazer aiaiaiia.");
                    break;
                case "EXIT":
                    System.out.println("Saindo do jogo. Até mais!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Comando não reconhecido. Digite HELP para ver os comandos disponíveis.");
            }
        }
    }
}
