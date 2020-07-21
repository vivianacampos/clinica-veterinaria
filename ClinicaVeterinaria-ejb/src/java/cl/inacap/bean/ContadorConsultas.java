/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bean;

import cl.inacap.modelo.Enfermedad;
import cl.inacap.modelo.Mascota;
import cl.inacap.modelo.MedicoVeteriario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.ejb.Singleton;

/**
 *
 * @author Viviana Campos
 */
@Singleton
public class ContadorConsultas implements ContadorConsultasLocal {

    ArrayList<Mascota> listaMascotas = new ArrayList();
    ArrayList<Enfermedad> listaEnf = new ArrayList();
    ArrayList<MedicoVeteriario> listaVeterinario = new ArrayList();
    


    
    private int contador = 0;

    public ContadorConsultas(){

    listaMascotas.add(new Mascota("Piolin", "Ave", "Canario", 1, "Macho", new Date(06/03/2019)));
    listaMascotas.add(new Mascota("Cachupin", "Perro", "Quiltro", 2, "Macho", new Date(06/03/2018)));
    listaMascotas.add(new Mascota("Michi", "Gato", "Mestizo", 2, "Hembra", new Date(28/02/2019)));

    listaEnf.add(new Enfermedad("Otitis", "Inflamacion aguda del oido medio", "7 dias", "Paracetamol por 7 dias y reposo"));
    listaEnf.add(new Enfermedad("Parasitos", "Parasitos internos", "Hasta que sea tratada", "Pastilla antiparasitaria"));
    listaEnf.add(new Enfermedad("Acaron", "Enfermedad Cutanea", "5 a 7 dias", "Insecticida apto para animales"));
    
    listaVeterinario.add(new MedicoVeteriario("Miguel", "Soto", 36, "Masculino", "Santiago", 569898989, 224565456, "Los Cardenales 098", "Cirugia"));
    listaVeterinario.add(new MedicoVeteriario("Francisca", "Rojas", 42, "Femenino", "Santiago", 569777777, 226655665, "Constantino 99", "Fisioterapia"));
    listaVeterinario.add(new MedicoVeteriario("Carmen", "Retamales", 27, "Femenino", "Santiago", 569777777, 226655665, "Constantino 99", "Cardiologia"));
    }

    public int getContador() {
        return contador;
    }

    public void setContador() {
        this.contador += 1;
    }

    public ArrayList<Mascota> getMascotas() {
        return listaMascotas;
    }
    public ArrayList<Enfermedad> getEnfermedades(){
        return listaEnf;
    }
    public ArrayList<MedicoVeteriario> getVeterinarios(){
        return listaVeterinario;
    }


}
