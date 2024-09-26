//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package service;

import java.sql.SQLException;
import java.util.List;
import model.Console;
import model.Inventario;
import model.Save;
import repository.InventarioDAO;
import repository.SaveDAO;

public class ComandoLoad {
    private Console console = new Console();

    public ComandoLoad() {
    }

    public Console executar(int idSave) {
        try {
            Save save = SaveDAO.findSaveById(idSave);
            if (save != null) {
                List<Inventario> inventarios = InventarioDAO.findInventariosBySaveId(String.valueOf(idSave));
                Console var10000 = this.console;
                int var10001 = save.getIdSave();
                var10000.setMensagem("Jogo carregado com sucesso. ID do Save: " + var10001 + "\nItens no inventário: " + inventarios.size());
                this.console.setIdSave(save.getIdSave());
            } else {
                this.console.setMensagem("Não foi possível encontrar o jogo com ID: " + idSave);
            }
        } catch (SQLException var4) {
            SQLException e = var4;
            this.console.setMensagem("Erro ao carregar o jogo: " + e.getMessage());
            e.printStackTrace();
        }

        return this.console;
    }
}
