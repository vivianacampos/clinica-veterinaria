/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bean;


import cl.inacap.modelo.MedicoVeteriario;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Viviana Campos
 */
@Local
public interface VeterinariaBeanLocal {
    public int getContador();
    public void setContador();
    public ArrayList<MedicoVeteriario> getVeterinarios();
     
}
