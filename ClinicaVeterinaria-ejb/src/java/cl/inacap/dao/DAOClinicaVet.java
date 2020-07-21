/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.dao;

import cl.inacap.modelo.Enfermedad;
import cl.inacap.conexion.Conexion;
import cl.inacap.modelo.Enfermedad;
import cl.inacap.modelo.Mascota;
import cl.inacap.modelo.MedicoVeteriario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;


/**
 *
 * @author Viviana Campos
 */


public class DAOClinicaVet extends Conexion{

    private Conexion conn = new Conexion();
    //Metodos para ingresar
    public int registrarMascota(Mascota masc){
        int cantidadFilas = 0;
        try {
            Connection con = conn.getConexion();
            con.setAutoCommit(false);
            String query = "insert into Mascota values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, masc.getNombre());
            ps.setString(2, masc.getEspecie());
            ps.setString(3, masc.getRaza());
            ps.setInt(4, masc.getEdad());
            ps.setString(5, masc.getSexo());
            ps.setDate(6, (Date) masc.getfNac());
            cantidadFilas = ps.executeUpdate();
            con.commit();
            ps.close();
            con.close();
            
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en Driver.", ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en SQL.", ex);
        }
        return cantidadFilas;
    }

    public int registarEnfermedad(Enfermedad enf) {
        int cantidadFilas = 0;
        try {
            Connection con = conn.getConexion();
            con.setAutoCommit(false);
            String query = "insert into Enfermedad values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, enf.getNombreEnf());
            ps.setString(2, enf.getDescripcion());
            ps.setString(3, enf.getPrevalencia());
            ps.setString(4, enf.getTto());

            cantidadFilas = ps.executeUpdate();
            con.commit();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en Driver.", e);
        } catch (SQLException e) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en SQL.", e);
        }

        return cantidadFilas;
    }

    public int registrarVeterinario(MedicoVeteriario vet) {
        int cantidadFilas = 0;

        try {
            Connection con = conn.getConexion();
            con.setAutoCommit(false);
            String query = "Insert into Veterinario values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, vet.getNombre());
            ps.setString(2, vet.getApellido());
            ps.setInt(3, vet.getEdad());
            ps.setString(4, vet.getSexo());
            ps.setString(5, vet.getCiudad());
            ps.setInt(6, vet.getTelefonoFijo());
            ps.setInt(7, vet.getTelefonoCelular());
            ps.setString(8, vet.getDireccion());
            ps.setString(9, vet.getEspecialidad());

            cantidadFilas = ps.executeUpdate();
            con.commit();
            ps.close();
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en Driver.", ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en SQL.", ex);
        }
        return cantidadFilas;
    }
    
    
    //Metodos para obtener listados
    public ArrayList<Enfermedad> getListaEnf(){
        ArrayList<Enfermedad> listaEnf = new ArrayList<>();
        Enfermedad enf;
        try {
            Connection con = conn.getConexion();
            String query = "select * from enfermedad";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                enf = new Enfermedad();
                enf.setNombreEnf(rs.getString("NOMBRE"));
                enf.setDescripcion(rs.getString("DESCRIPCION"));
                enf.setPrevalencia(rs.getString("PREVALENCIA"));
                enf.setTto(rs.getString("TRATAMIENTO"));
                listaEnf.add(enf);
            }
            rs.close();
            ps.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en Driver.", e);
        } catch (SQLException e) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en SQL.", e);
        }
        
        return listaEnf;
    }
    
    public ArrayList<MedicoVeteriario> getListatVet(){
        ArrayList<MedicoVeteriario> listaVet = new ArrayList<>();
        MedicoVeteriario vet;
        try {
            Connection con = conn.getConexion();
            String query = "select * from veterinario";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                vet = new MedicoVeteriario();
                vet.setNombre(rs.getString("NOMBRE"));
                vet.setApellido(rs.getString("APELLIDO"));
                vet.setEdad(rs.getInt("EDAD"));
                vet.setSexo(rs.getString("SEXO"));
                vet.setCiudad(rs.getString("CIUDAD"));
                vet.setTelefonoFijo(rs.getInt("TELEFONO"));
                vet.setTelefonoCelular(rs.getInt("CELULAR"));
                vet.setDireccion(rs.getString("DIRECCION"));
                vet.setEspecialidad(rs.getString("ESPECIALIDAD"));
                listaVet.add(vet);
            }
            rs.close();
            ps.close();
            con.close();
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en Driver.", e);
        } catch (SQLException e) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en SQL.", e);
        }
        return listaVet;
    }
    
    public ArrayList<Mascota> getListaMasc(){
        ArrayList<Mascota> listaMasc = new ArrayList<>();
        Mascota masc;
        try {
            Connection con = conn.getConexion();
            String query = "select * from mascota";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                masc = new Mascota();
                masc.setNombre(rs.getString("NOMBRE"));
                masc.setEspecie(rs.getString("ESPECIE"));
                masc.setRaza(rs.getString("RAZA"));
                masc.setEdad(rs.getInt("EDAD"));
                masc.setSexo(rs.getString("SEXO"));
                masc.setfNac(rs.getDate("FECHA_NAC"));
                listaMasc.add(masc);
            }
            rs.close();
            ps.close();
            con.close();
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en Driver.", e);
        } catch (SQLException e) {
            Logger.getLogger(DAOClinicaVet.class.getName()).log(Level.SEVERE,
                    "Insercion - Error en SQL.", e);
        }
        
        return listaMasc;
    }
    
    
    //Metodos para modificar
    
    
    //Metodos para eliminar
}
