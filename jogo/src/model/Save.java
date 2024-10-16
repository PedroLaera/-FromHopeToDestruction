//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

import java.sql.SQLException;
import repository.CenaDAO;
import repository.SaveDAO;

public class Save {
    private int idSave;
    private Cena cenaAtual;
    private String nomeJogador;

    public Save() {
    }

    public int getIdSave() {
        return this.idSave;
    }

    public void setIdSave(int idSave) {
        this.idSave = idSave;
    }

    public Cena getCenaAtual() {
        return this.cenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    public String getNomeJogador() {
        return this.nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public void atualizarCenaAtual(int novoIdCena) throws SQLException {
        this.cenaAtual = CenaDAO.findCenaById(novoIdCena);
        SaveDAO.updateIdCenaAtual(this.idSave, novoIdCena);
    }
}
