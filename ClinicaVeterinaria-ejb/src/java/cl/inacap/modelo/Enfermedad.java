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
    private String prevalencia;
    private String tto;

    public Enfermedad() {
    }

    public Enfermedad(String nombreEnf, String descripcion, String prevalencia, String tto) {
        this.nombreEnf = nombreEnf;
        this.descripcion = descripcion;
        this.prevalencia = prevalencia;  //tiempo de duracion de la enfermedad
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

    public String getPrevalencia() {
        return prevalencia;
    }

    public void setPrevalencia(String prevalencia) {
        this.prevalencia = prevalencia;
    }

    public String getTto() {
        return tto;
    }

    public void setTto(String tto) {
        this.tto = tto;
    }
    
    
    
}
