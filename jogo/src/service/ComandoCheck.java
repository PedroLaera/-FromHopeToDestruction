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

public class ComandoCheck {
    private Console console = new Console();

    public ComandoCheck() {
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

            Console var10000 = this.console;
            String var10001 = itemEncontrado.getNome();
            var10000.setMensagem("Item: " + var10001 + "\nDescrição: " + itemEncontrado.getDescricaoPositiva());
        } catch (Exception var6) {
            Exception e = var6;
            this.console.setMensagem("Erro ao executar o comando CHECK: " + e.getMessage());
        }

        return this.console;
    }
}
