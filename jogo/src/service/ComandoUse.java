//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package service;

import model.Console;
import model.Item;
import model.Save;
import repository.ItemDAO;
import repository.SaveDAO;

public class ComandoUse {
    private Console console = new Console();

    public ComandoUse() {
    }

    public Console executar(String nomeItem, int idSave) {
        try {
            Save save = SaveDAO.findSaveById(idSave);
            if (save == null) {
                this.console.setMensagem("Jogo salvo não encontrado.");
                return this.console;
            }

            int idCenaAtual = save.getCenaAtual().getId();
            Item itemEncontrado = ItemDAO.findItemByCenaId(idCenaAtual, nomeItem);
            if (itemEncontrado == null) {
                this.console.setMensagem("O item '" + nomeItem + "' não está presente nesta cena.");
                return this.console;
            }

            String comandoCorreto = "USE " + nomeItem;
            if (itemEncontrado.getComandoCorreto().equalsIgnoreCase(comandoCorreto)) {
                this.console.setMensagem("Você usou " + nomeItem + ". " + itemEncontrado.getDescricaoPositiva());
                if (itemEncontrado.getIdProximaCena() != null) {
                    save.atualizarCenaAtual(itemEncontrado.getIdProximaCena());
                    Console var10000 = this.console;
                    String var10001 = this.console.getMensagem();
                    var10000.setMensagem(var10001 + "\n\n" + save.getCenaAtual().getDescricao());
                }
            } else {
                this.console.setMensagem(itemEncontrado.getDescricaoNegativa());
            }
        } catch (Exception var7) {
            Exception e = var7;
            this.console.setMensagem("Erro ao executar o comando USE: " + e.getMessage());
        }

        return this.console;
    }
}
