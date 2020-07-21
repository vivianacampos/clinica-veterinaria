/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bean;


import cl.inacap.modelo.Enfermedad;
import cl.inacap.modelo.Mascota;
import cl.inacap.modelo.MedicoVeteriario;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Viviana Campos
 */
@Local
public interface ContadorConsultasLocal {
    public int getContador();
    public void setContador();
    public ArrayList<Mascota> getMascotas();
    public ArrayList<Enfermedad> getEnfermedades();
    public ArrayList<MedicoVeteriario> getVeterinarios();

     
}
