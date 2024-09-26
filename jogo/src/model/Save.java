package model;

public class Save {
    private Integer idSave;
    private Integer idCenaAtual;

    public Integer getIdSave() {
        return idSave;
    }

    public String setIdSave(Integer idSave) {
        this.idSave = idSave;
        return null;
    }

    public Integer getIdCenaAtual() {
        return idCenaAtual;
    }

    public void setIdCenaAtual(Integer idCenaAtual) {
        this.idCenaAtual = idCenaAtual;
    }

    @Override
    public String toString() {
        return "Save{" +
                "idSave=" + idSave +
                ", idCenaAtual=" + idCenaAtual +
                '}';
    }
}