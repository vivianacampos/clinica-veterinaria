/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.modelo;

/**
 *
 * @author Viviana Campos
 */
public class Enfermedad {
    private String nombreEnf;
    private String descripcion;
    private String prevalenca;
    private String tto;

    public Enfermedad() {
    }

    public Enfermedad(String nombreEnf, String descripcion, String prevalenca, String tto) {
        this.nombreEnf = nombreEnf;
        this.descripcion = descripcion;
        this.prevalenca = prevalenca;  //tiempo de duracion de la enfermedad
        this.tto = tto;
    }

    public String getNombreEnf() {
        return nombreEnf;
    }

    public void setNombreEnf(String nombreEnf) {
        this.nombreEnf = nombreEnf;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrevalenca() {
        return prevalenca;
    }

    public void setPrevalenca(String prevalenca) {
        this.prevalenca = prevalenca;
    }

    public String getTto() {
        return tto;
    }

    public void setTto(String tto) {
        this.tto = tto;
    }
    
    
    
}
