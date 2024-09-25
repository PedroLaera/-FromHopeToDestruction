package model;

public class Save {
    private Integer idSave;
    private Integer idCenaAtual;

    public Integer getIdCenaAtual() {
        return idCenaAtual;
    }

    public void setIdCenaAtual(Integer idCenaAtual) {
        this.idCenaAtual = idCenaAtual;
    }

    public Integer getIdSave() {
        return idSave;
    }

    public void setIdSave(Integer idSave) {
        this.idSave = idSave;
    }

    @Override
    public String toString() {
        return "Save{" +
                "idSave=" + idSave +
                ", idCenaAtual=" + idCenaAtual +
                '}';
    }
}