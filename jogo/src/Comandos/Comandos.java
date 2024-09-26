//package Comandos;
//
//import java.util.Scanner;
//import model.Console;
//import service.ComandoCheck;
//import service.ComandoGet;
//import service.ComandoHelp;
//import service.ComandoInventory;
//import service.ComandoLoad;
//import service.ComandoRestart;
//import service.ComandoStart;
//import service.ComandoUse;
//
//public class Comandos {
//    public Comandos() {
//    }
//
//    public void executarComandos() {
//        Scanner scanner = new Scanner(System.in);
//        ComandoHelp comandoHelp = new ComandoHelp();
//        ComandoStart comandoStart = new ComandoStart();
//        ComandoUse comandoUse = new ComandoUse();
//        ComandoGet comandoGet = new ComandoGet();
//        ComandoInventory comandoInventory = new ComandoInventory();
//        ComandoCheck comandoCheck = new ComandoCheck();
//        new ComandoLoad();
//        ComandoRestart comandoRestart = new ComandoRestart();
//
//        System.out.println("Bem-vindo ao jogo!");
//        Console console = (Console) comandoStart.executar().get(0);
//        System.out.println(console.getMensagem());
//        int idSave = console.getIdSave();
//
//        while (true) {
//            System.out.print("> ");
//            String input = scanner.nextLine();
//            String[] parts = input.trim().split("\\s+");
//            if (parts.length != 0 && !parts[0].isEmpty()) {
//                String itemNome;
//                switch (parts[0].toUpperCase()) {
//                    case "HELP":
//                        System.out.println(comandoHelp.executar());
//                        break;
//                    case "CHECK":
//                        if (parts.length > 1) {
//                            itemNome = parts[1];
//                            System.out.println(comandoCheck.executar(itemNome, idSave).getMensagem());
//                        } else {
//                            System.out.println("Por favor, especifique o item a ser verificado.");
//                        }
//                        break;
//                    case "GET":
//                        if (parts.length > 1) {
//                            itemNome = parts[1];
//                            System.out.println(comandoGet.executar(itemNome, idSave).getMensagem());
//                        } else {
//                            System.out.println("Por favor, especifique o item a ser pego.");
//                        }
//                        break;
//                    case "INVENTORY":
//                        System.out.println(comandoInventory.executar(idSave).getMensagem());
//                        break;
//                    case "USE":
//                        if (parts.length > 3 && parts[2].equalsIgnoreCase("WITH")) {
//                            itemNome = parts[1];
//                            String itemCenaNome = parts[3];
//                            System.out.println(comandoUse.executar(itemNome, idSave).getMensagem());
//                        } else if (parts.length > 1) {
//                            itemNome = parts[1];
//                            System.out.println(comandoUse.executar(itemNome, idSave).getMensagem());
//                        } else {
//                            System.out.println("Por favor, especifique o item a ser usado.");
//                        }
//                        break;
//                    case "RESTART":
//                        System.out.println(comandoRestart.executar(idSave).getMensagem());
//                        break;
//                    case "SAVE":
//                        System.out.println("Jogo salvo com sucesso!");
//                        break;
//                    case "LOAD":
//                        System.out.println("Carregando...");
//                        break;
//                    case "EXIT":
//                        System.out.println("Saindo do jogo...\nAté Mais, Te Espero Por Aqui!!");
//                        scanner.close();
//                        return;
//                    default:
//                        System.out.println("Comando errado, o monstro se aproxima");
//                }
//            } else {
//                System.out.println("Por favor, insira um comando. Digite *HELP* para ver os comandos disponíveis.");
//            }
//        }
//    }
//}