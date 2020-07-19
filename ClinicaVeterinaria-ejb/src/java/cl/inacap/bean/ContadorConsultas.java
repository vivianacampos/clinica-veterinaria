/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bean;

import cl.inacap.modelo.MedicoVeteriario;
import java.util.ArrayList;
import javax.ejb.Singleton;

/**
 *
 * @author Viviana Campos
 */
@Singleton
public class ContadorConsultas implements VeterinariaBeanLocal {

    ArrayList<MedicoVeteriario> listaVet = new ArrayList();
    


    
    private int contador = 0;

    public ContadorConsultas() {
        listaVet.add(new MedicoVeteriario("Crisitan", "Rodriguez", 35, "Masculino", "Santiago", 225566556, 977008877, "Las golondrinas 2020", "Fisioterapia"));
        listaVet.add(new MedicoVeteriario("Miguel", "Soto", 52, "Masculino", "Quilicura", 225566588, 977008899, "Pasaje tokio 8585", "Cardiología"));
        listaVet.add(new MedicoVeteriario("Sandra", "Uribe", 40, "Femenino", "San Miguel", 225566457, 977008889, "Pasaje Canada 1515", "Neurología"));
    }

    public int getContador() {
        return contador;
    }

    public void setContador() {
        this.contador += 1;
    }

    public ArrayList<MedicoVeteriario> getVeterinarios() {
        return listaVet;
    }


}
