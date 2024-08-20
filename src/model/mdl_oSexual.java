package model;

public class mdl_oSexual {

    private int id_Sexual;
    private String descipcion;
    public mdl_oSexual(int id_Sexual, String descipcion) {
        this.id_Sexual = id_Sexual;
        this.descipcion = descipcion;
    }

    public int getId_Sexual() {
        return id_Sexual;
    }

    public void setId_Sexual(int id_Sexual) {
        this.id_Sexual = id_Sexual;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }
}
