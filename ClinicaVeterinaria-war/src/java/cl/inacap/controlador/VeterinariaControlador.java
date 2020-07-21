/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.controlador;

import cl.inacap.bean.ContadorConsultasLocal;
import cl.inacap.dao.DAOClinicaVet;
import cl.inacap.modelo.Enfermedad;
import cl.inacap.modelo.Mascota;
import cl.inacap.modelo.MedicoVeteriario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Artsk
 */
@WebServlet(name = "VeterinariaControlador", urlPatterns = {"/registrarMascota.do","/registrarVeterinario.do","/registrarEnfermedad.do", "/actualizarMascota.do","/actualizarVeteriniario.do", "/actualizarEnfermedad.do","/eliminarMascota.do","/eliminarVeterinario.do","/eliminarEnfermedad.do", "/listarMascota.do", "/listarVeterinario.do", "/listarEnfermedad.do"})
public class VeterinariaControlador extends HttpServlet {

    @EJB
    private ContadorConsultasLocal contadorConsultas;
    DAOClinicaVet daoCli = new DAOClinicaVet();
    ArrayList<Mascota> listaMas = new ArrayList();
    ArrayList<Enfermedad> listaEnf = new ArrayList();
    ArrayList<MedicoVeteriario> listaVet = new ArrayList();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/listarEnfermedad.do")) {
            listaEnf = daoCli.getListaEnf();
            request.setAttribute("listaEnf", listaEnf);
            request.getRequestDispatcher("enfermedad.jsp").forward(request, response);
            contadorConsultas.setContador();

        } else if (request.getServletPath().equals("/registrarEnfermedad.do")) {
           Enfermedad enf;
           String msg = "";
           String enfermedad = request.getParameter("enfermedad");
           String descripcion = request.getParameter("descripcion");
           String prevalencia = request.getParameter("prevalencia");
           String tratamiento = request.getParameter("tratamiento");
           enf = new Enfermedad(enfermedad, descripcion, prevalencia, tratamiento);
           int enferm = daoCli.registarEnfermedad(enf);
           if(enferm>0){
                msg = "Inserción correcta de la Enfermedad";
            }else  {
                msg ="Error en la insercion";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("enfermedad.jsp").forward(request, response);
            contadorConsultas.setContador();
        } else if (request.getServletPath().equals("/registrarVeterinario.do")){
            MedicoVeteriario vet;
            String msg = "";
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            String ciudad = request.getParameter("ciudad");
            int telefonoFijo = Integer.parseInt(request.getParameter("telefonoFijo"));
            int telefonoCelular = Integer.parseInt(request.getParameter("telefonoCelular"));
            String direccion = request.getParameter("direccion");
            String especialidad = request.getParameter("especialidad");
            vet = new MedicoVeteriario(nombre, apellido, edad, sexo, ciudad, telefonoFijo, telefonoCelular, direccion, especialidad);
            int vete = daoCli.registrarVeterinario(vet);
            if(vete>0){
                 msg = "Inserción correcta de Medico Veterinario";
            }else  {
                msg ="Error en la insercion";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("veterinario.jsp").forward(request, response);
            contadorConsultas.setContador();
            
        } else if (request.getServletPath().equals("/listarVeterinario.do")){
            listaVet = daoCli.getListatVet();
            request.setAttribute("listaVet", listaVet);
            request.getRequestDispatcher("veterinario.jsp").forward(request, response);
            contadorConsultas.setContador();
        }else if(request.getServletPath().equals("/registrarMascota.do")){
            String msg = "";
            Mascota masc;
            String nombre = request.getParameter("nombre");
            String especie = request.getParameter("especie");
            String raza = request.getParameter("raza");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            Date fNac = Date.valueOf("fNac");
            masc = new Mascota(nombre, especie, raza, edad, sexo, fNac);
            int mas = daoCli.registrarMascota(masc);
            if(mas>0){
                  msg = "Inserción correcta de Mascota";
            }else  {
                msg ="Error en la insercion";
            }
            contadorConsultas.setContador();
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("mascota.jsp").forward(request, response);
            
        }else if(request.getServletPath().equals("/listarMascota.do")){
            listaMas = daoCli.getListaMasc();
            request.setAttribute("listaMas", listaMas);
            request.getRequestDispatcher("mascota.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
