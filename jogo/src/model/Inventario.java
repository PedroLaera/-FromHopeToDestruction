//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

public class Inventario {
    private Integer idInventario;
    private String nomeItem;
    private String descricao;
    private Integer id_save;

    public Inventario() {
    }

    public Integer getIdInventario() {
        return this.idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public String getNomeItem() {
        return this.nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId_save() {
        return this.id_save;
    }

    public void setId_save(Integer id_save) {
        this.id_save = id_save;
    }

    public String toString() {
        return "Inventario [idInventario=" + this.idInventario + ", nomeItem=" + this.nomeItem + ", descricao=" + this.descricao + ", id_save=" + this.id_save + "]";
    }

    public Object getQuantidade() {
        throw new UnsupportedOperationException("Unimplemented method 'getQuantidade'");
    }
}
