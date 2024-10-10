//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package service;

import java.sql.SQLException;
import model.Console;
import model.Save;
import repository.InventarioDAO;
import repository.SaveDAO;

public class ComandoRestart {
    private Console console = new Console();

    public ComandoRestart() {
    }

    public Console executar(int idSave) {
        if (idSave <= 0) {
            this.console.setMensagem("ID do Save inválido.");
            return this.console;
        }

        try {
            Save save = SaveDAO.findSaveById(idSave);
            if (save != null) {
                this.reiniciarEstadoInicial(save);
                this.console.setMensagem("O jogo foi reiniciado com sucesso. ID do Save: " + save.getIdSave());
            } else {
                this.console.setMensagem("Não foi possível encontrar o jogo para reiniciar.");
            }
        } catch (SQLException e) {
            this.console.setMensagem("Erro ao reiniciar o jogo: " + e.getMessage());
            e.printStackTrace(); // Considere usar um logger aqui
        }

        return this.console;
    }

    private void reiniciarEstadoInicial(Save save) throws SQLException {
        InventarioDAO.clearInventarioBySaveId(save.getIdSave());
        SaveDAO.resetSaveToInitialState(save.getIdSave());
    }
}