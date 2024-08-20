package model;

public class mdl_aPolitica {
    private int id_Politica;
    private String nombre;

    public mdl_aPolitica(int id_Politica, String nombre) {
        this.id_Politica = id_Politica;
        this.nombre = nombre;
    }

    public int getId_Politica() {
        return id_Politica;
    }

    public void setId_Politica(int id_Politica) {
        this.id_Politica = id_Politica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
