package model;

import java.util.List;

public class Cena {
    private Integer id;
    private String descricao;
    private List<Item> itens;

    public Cena() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public String toString() {
        Integer var10000 = this.id;
        return "Cena{id=" + var10000 + ", descricao='" + this.descricao + "', itens=" + String.valueOf(this.itens) + "}";
    }

    public int getIdCena() {
        throw new UnsupportedOperationException("Unimplemented method 'getIdCena'");
    }
}
