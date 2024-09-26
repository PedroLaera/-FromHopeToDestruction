package service;

import model.Console;
import model.Item;
import model.Save;
import repository.ItemDAO;
import repository.SaveDAO;

public class ComandoCheck {
    private Console console;

    public ComandoCheck() {
        this.console = new Console();
    }

    public Console executar(String nomeItem, int idSave) {
        try {

            Save save = SaveDAO.findSaveById(idSave);
            if (save == null) {
                console.setMensagem("Jogo salvo não encontrado.");
                return console;
            }

            int idCenaAtual = save.getCenaAtual().getId();


            Item itemEncontrado = ItemDAO.findItemByCenaId(idCenaAtual, nomeItem);
            if (itemEncontrado == null) {
                console.setMensagem("O item '" + nomeItem + "' não está presente nesta cena.");
                return console;
            }


            console.setMensagem("Item: " + itemEncontrado.getNome() + "\nDescrição: " + itemEncontrado.getDescricaoPositiva());

        } catch (Exception e) {
            console.setMensagem("Erro ao executar o comando CHECK: " + e.getMessage());
        }
        return console;
    }
}
