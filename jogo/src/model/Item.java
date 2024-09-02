package model;

public class Item {
    private Integer idItem;
    private String nome;
    private String descricaoPositiva;
    private String descricaoNegativa;
    private String comandoCorreto;
    private Cena cenaAtual;
    private Cena cenaSeguinte;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
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

    public Cena getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    public Cena getCenaSeguinte() {
        return cenaSeguinte;
    }

    public void setCenaSeguinte(Cena cenaSeguinte) {
        this.cenaSeguinte = cenaSeguinte;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nome='" + nome + '\'' +
                ", descricaoPositiva='" + descricaoPositiva + '\'' +
                ", descricaoNegativa='" + descricaoNegativa + '\'' +
                ", comandoCorreto='" + comandoCorreto + '\'' +
                ", cenaAtual=" + cenaAtual +
                ", cenaSeguinte=" + cenaSeguinte +
                '}';
    }
}
