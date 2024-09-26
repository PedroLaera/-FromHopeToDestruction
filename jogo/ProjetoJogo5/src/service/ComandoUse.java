package service;

import model.Console;
import model.Item;
import model.Save;
import repository.ItemDAO;
import repository.SaveDAO;

public class ComandoUse {
    private Console console;

    public ComandoUse() {
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


            String comandoCorreto = "USE " + nomeItem;
            if (itemEncontrado.getComandoCorreto().equalsIgnoreCase(comandoCorreto)) {
                console.setMensagem("Você usou " + nomeItem + ". " + itemEncontrado.getDescricaoPositiva());


                if (itemEncontrado.getIdProximaCena() != null) {

                    save.atualizarCenaAtual(itemEncontrado.getIdProximaCena());
                    console.setMensagem(console.getMensagem() + "\n\n" + save.getCenaAtual().getDescricao());
                }

            } else {
                console.setMensagem(itemEncontrado.getDescricaoNegativa());
            }

        } catch (Exception e) {
            console.setMensagem("Erro ao executar o comando USE: " + e.getMessage());
        }
        return console;
    }
}
