//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package service;

public class ComandoHelp {
    public ComandoHelp() {
    }

    public String executar() {
        return "Comandos disponíveis:" +
                "HELP: exibe este menu de ajuda" +
                "\nUSE [ITEM]: interage com o item da cena" +
                "\nCHECK [ITEM]: mostra a descrição do objeto na cena" +
                "\nGET [ITEM]: se possível, adiciona o item ao inventário" +
                "\nINVENTORY: mostra os itens que estão no inventário" +
                "\nUSE [INVENTORY_ITEM] WITH [SCENE_ITEM]: usa um item do inventário com um item da cena" +
                "\nRESTART: reinicia o jogo" +
                "\nEXIT: sai do jogo";
    }
}

