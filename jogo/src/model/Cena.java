package model;

import java.util.List;

public class Cena {
    private int idCena;
    private String descricao;
    private Integer idCenaSeguinte;
    private List<Item> itens;

    public Cena() {
    }

    public Integer getIdCena() {
        return idCena;
    }

    public void setIdCena(Integer idCena) {
        this.idCena = idCena;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdCenaSeguinte() {
        return idCenaSeguinte;
    }

    public void setIdCenaSeguinte(Integer idCenaSeguinte) {
        this.idCenaSeguinte = idCenaSeguinte;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens() {
        this.itens = itens;
    }



    public void getIdCena(Item itemEncontrado) {
    }

    @Override
    public String toString() {
        return "Cena{" +
                "idCena=" + idCena +
                ", descricao='" + descricao + '\'' +
                ", idCenaSeguinte=" + idCenaSeguinte +
                ", itens=" + itens +
                '}';
    }
}