package service;

public class ComandoHelp {
    public String executar() {
        return "Comandos disponíveis:\n" +
                "HELP: exibe este menu de ajuda\n" +
                "USE [ITEM]: interage com o item da cena\n" +
                "CHECK [ITEM]: mostra a descrição do objeto na cena\n" +
                "GET [ITEM]: se possível, adiciona o item ao inventário\n" +
                "INVENTORY: mostra os itens que estão no inventário\n" +
                "USE [INVENTORY_ITEM] WITH [SCENE_ITEM]: usa um item do inventário com um item da cena\n" +
                "RESTART: reinicia o jogo\n" +
                "EXIT: sai do jogo";
    }
}
