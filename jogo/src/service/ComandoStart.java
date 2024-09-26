//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package service;

import java.util.ArrayList;
import java.util.List;
import model.Console;
import model.Save;
import repository.SaveDAO;

public class ComandoStart {
    private Console console = new Console();
    private List<Console> listaConsole = new ArrayList();

    public ComandoStart() {
    }

    public List<Console> executar() {
        try {
            Save save = SaveDAO.novoJogo();
            if (save != null && save.getCenaAtual() != null) {
                this.console.setMensagem(save.getCenaAtual().getDescricao());
                this.console.setIdSave(save.getIdSave());
                this.listaConsole.add(this.console);
            } else {
                this.console.setMensagem("Não foi possível iniciar o jogo.");
                this.listaConsole.add(this.console);
            }
        } catch (Exception var2) {
            Exception e = var2;
            this.console.setMensagem("Erro ao iniciar o jogo: " + e.getMessage());
            e.printStackTrace();
            this.listaConsole.add(this.console);
        }

        return this.listaConsole;
    }
}
