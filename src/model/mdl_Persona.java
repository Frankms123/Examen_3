package model;


import java.io.Reader;
import java.sql.Date;

public class mdl_Persona {


    // Create the class attributes
    private int id_Persona;
        private int cedula;
        private String nombre;
        private String apell1;
        private String apell2;
        private char sexo;
        private char ecivil ;
        private Date Nacido;
        private String provincia;
        private String Osexual;
        private String aPolitica;
        private String nAcademico;
        private int Salario;

    public mdl_Persona(int cedula, String nombre, String apell1, String apell2, char sexo, char ecivil, Date nacido, String provincia, String osexual, String aPolitica, String nAcademico, int salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apell1 = apell1;
        this.apell2 = apell2;
        this.sexo = sexo;
        this.ecivil = ecivil;
        Nacido = nacido;
        this.provincia = provincia;
        Osexual = osexual;
        this.aPolitica = aPolitica;
        this.nAcademico = nAcademico;
        Salario = salario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApell1() {
        return apell1;
    }

    public void setApell1(String apell1) {
        this.apell1 = apell1;
    }

    public String getApell2() {
        return apell2;
    }

    public void setApell2(String apell2) {
        this.apell2 = apell2;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getEcivil() {
        return ecivil;
    }

    public void setEcivil(char ecivil) {
        this.ecivil = ecivil;
    }

    public Date getNacido() {
        return Nacido;
    }

    public void setNacido(Date nacido) {
        Nacido = nacido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getOsexual() {
        return Osexual;
    }

    public void setOsexual(String osexual) {
        Osexual = osexual;
    }

    public String getaPolitica() {
        return aPolitica;
    }

    public void setaPolitica(String aPolitica) {
        this.aPolitica = aPolitica;
    }

    public String getnAcademico() {
        return nAcademico;
    }

    public void setnAcademico(String nAcademico) {
        this.nAcademico = nAcademico;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }
}
