package model;

public class Item {

    private Integer idItem;
    private Cena id_Cena;
    private String nome;
    private String descricaoPositiva;
    private String descricaoNegativa;
    private String comandoCorreto;
    private Boolean interagivel;
    private Integer idProximaCena;

    public Item() {}

    public Item(Integer idItem, Cena id_Cena, String nome, String descricaoPositiva, String descricaoNegativa, String comandoCorreto, Boolean interagivel) {
        this.idItem = idItem;
        this.id_Cena = id_Cena;
        this.nome = nome;
        this.descricaoPositiva = descricaoPositiva;
        this.descricaoNegativa = descricaoNegativa;
        this.comandoCorreto = comandoCorreto;
        this.interagivel = interagivel;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Cena getId_Cena() {
        return id_Cena;
    }

    public void setId_Cena(Cena id_Cena) {
        this.id_Cena = id_Cena;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoPositiva() {
        return descricaoPositiva;
    }

    public void setDescricaoPositiva(String descricaoPositiva) {
        this.descricaoPositiva = descricaoPositiva;
    }

    public String getDescricaoNegativa() {
        return descricaoNegativa;
    }

    public void setDescricaoNegativa(String descricaoNegativa) {
        this.descricaoNegativa = descricaoNegativa;
    }

    public String getComandoCorreto() {
        return comandoCorreto;
    }

    public void setComandoCorreto(String comandoCorreto) {
        this.comandoCorreto = comandoCorreto;
    }

    public Boolean getInteragivel() {
        return interagivel;
    }

    public void setInteragivel(Boolean interagivel) {
        this.interagivel = interagivel;
    }

    public Integer getIdProximaCena() {
        return idProximaCena;
    }

    public void setIdProximaCena(Integer idProximaCena) {
        this.idProximaCena = idProximaCena;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", id_Cena=" + id_Cena +
                ", nome='" + nome + '\'' +
                ", descricaoPositiva='" + descricaoPositiva + '\'' +
                ", descricaoNegativa='" + descricaoNegativa + '\'' +
                ", comandoCorreto='" + comandoCorreto + '\'' +
                ", interagivel=" + interagivel +
                '}';
    }

    public String getDescricao() {

        throw new UnsupportedOperationException("nao deu");
    }

    public String getDetalhes() {

        throw new UnsupportedOperationException("ainda nao foi ");
    }
}
