package model;
import repository.CenaDAO;
import repository.SaveDAO;

import java.sql.SQLException;

public class Save {
    private int idSave;
    private Cena cenaAtual;
    private String nomeJogador;

    public int getIdSave() {
        return idSave;
    }

    public void setIdSave(int idSave) {
        this.idSave = idSave;
    }

    public Cena getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public void atualizarCenaAtual(int novoIdCena) throws SQLException {
        this.cenaAtual = CenaDAO.findCenaById(novoIdCena);
        SaveDAO.updateIdCenaAtual(this.idSave, novoIdCena);
    }

}
