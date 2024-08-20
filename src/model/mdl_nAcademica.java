package model;

public class mdl_nAcademica {
    private int id_academica;
    private String Descripcion;

    public mdl_nAcademica(int id_academica, String descripcion) {
        this.id_academica = id_academica;
        Descripcion = descripcion;
    }

    public int getId_academica() {
        return id_academica;
    }

    public void setId_academica(int id_academica) {
        this.id_academica = id_academica;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
