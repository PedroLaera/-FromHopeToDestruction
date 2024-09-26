//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.*;
import java.util.Scanner;
import model.Console;
import service.ComandoCheck;
import service.ComandoGet;
import service.ComandoHelp;
import service.ComandoInventory;
import service.ComandoLoad;
import service.ComandoRestart;
import service.ComandoStart;
import service.ComandoUse;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComandoHelp comandoHelp = new ComandoHelp();
        ComandoStart comandoStart = new ComandoStart();
        ComandoUse comandoUse = new ComandoUse();
        ComandoGet comandoGet = new ComandoGet();
        ComandoInventory comandoInventory = new ComandoInventory();
        ComandoCheck comandoCheck = new ComandoCheck();
        new ComandoLoad();
        ComandoRestart comandoRestart = new ComandoRestart();
        System.out.println("Bem-vindo ao jogo!\nLucas, um jovem fã de jogos de terror, decide trabalhar como segurança noturno no famoso restaurante Freddy Fazbear’s Pizza. \nEle sabe que a noite será desafiadora, mas está determinado a enfrentar o que vier. À medida que avança, ele precisa coletar \nobjetos importantes para sobreviver!");
        Console console = (Console)comandoStart.executar().get(0);
        System.out.println(console.getMensagem());
        int idSave = console.getIdSave();

        while(true) {
            while(true) {
                System.out.print("> ");
                String input = scanner.nextLine();
                String[] parts = input.trim().split("\\s+");
                if (parts.length != 0 && !parts[0].isEmpty()) {
                    String itemNome;
                    switch (parts[0].toUpperCase()) {
                        case "HELP":
                            System.out.println(comandoHelp.executar());
                            break;
                        case "CHECK":
                            if (parts.length > 1) {
                                itemNome = parts[1];
                                System.out.println(comandoCheck.executar(itemNome, idSave).getMensagem());
                            } else {
                                System.out.println("Por favor, especifique o item a ser verificado.");
                            }
                            break;
                        case "GET":
                            if (parts.length > 1) {
                                itemNome = parts[1];
                                System.out.println(comandoGet.executar(itemNome, idSave).getMensagem());
                            } else {
                                System.out.println("Por favor, especifique o item a ser pego.");
                            }
                            break;
                        case "INVENTORY":
                            System.out.println(comandoInventory.executar(idSave).getMensagem());
                            break;
                        case "USE":
                            if (parts.length > 3 && parts[2].equalsIgnoreCase("WITH")) {
                                itemNome = parts[1];
                                String itemCenaNome = parts[3];
                                System.out.println(comandoUse.executar(itemNome, idSave).getMensagem());
                            } else if (parts.length > 1) {
                                itemNome = parts[1];
                                System.out.println(comandoUse.executar(itemNome, idSave).getMensagem());
                            } else {
                                System.out.println("Por favor, especifique o item a ser usado.");
                            }
                            break;
                        case "USE PIX":
                            StringBuilder resultado = new StringBuilder();
                            String query = "SELECT i.id AS id_item, i.nome AS nome_item, " +
                                    "i.descricao_positiva, i.descricao_negativa, c.descricao AS descricao_cena_destino " +
                                    "FROM itens_da_cena i " +
                                    "INNER JOIN cenas c ON i.id_cena_destino = c.id " +
                                    "WHERE i.id_cena_atual = ? AND c.id = ?";

                            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo", "root", "");
                                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                                pstmt.setInt(1, 11); // Cena atual
                                pstmt.setInt(2, 1); // Cena de destino
                                ResultSet rs = pstmt.executeQuery();

                                while (rs.next()) {
                                    resultado.append("ID Item: ").append(rs.getInt("id_item"))
                                            .append(", Nome: ").append(rs.getString("nome_item"))
                                            .append(", Descrição Positiva: ").append(rs.getString("descricao_positiva"))
                                            .append(", Descrição Negativa: ").append(rs.getString("descricao_negativa"))
                                            .append(", Descrição da Cena de Destino: ").append(rs.getString("descricao_cena_destino")).append("\n");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                                return;
                            }

                        case "1":
                            System.out.println(comandoRestart.executar(1));
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
                } else {
                    System.out.println("Por favor, insira um comando. Digite HELP para ver os comandos disponíveis.");
                }
            }
        }
    }
}
