/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.controlador;

import cl.inacap.dao.DAOClinicaVet;
import cl.inacap.modelo.Mascota;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Artsk
 */
@WebServlet(name = "VeterinariaControlador", urlPatterns = {"/registrar.do", "/buscar.do"})
public class VeterinariaControlador extends HttpServlet {
    DAOClinicaVet daoCli = new DAOClinicaVet();
    ArrayList<Mascota> listaMas;
    Mascota masc;
    String msg = "";
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
        if (request.getServletPath().equals("/buscar.do")) {
            listaMas = daoCli.getListaMasc();
            request.setAttribute("listaMasc", listaMas);
            request.getRequestDispatcher("buscar.jsp").forward(request, response);
            
        } else if(request.getServletPath().equals("/registrar.do")){
            String nombre = request.getParameter("nombre");
            String especie = request.getParameter("especie");
            String raza = request.getParameter("raza");
            int edad = Integer.parseInt(request.getParameter("edad"));
            Date fechaNac = Date.valueOf(request.getParameter("fechaNac"));
            String sexo = request.getParameter("sexo");
            Mascota mascota = new Mascota(nombre, especie, raza, edad, sexo, fechaNac);
            int mas = daoCli.registrarMascota(mascota);
            if(mas>0){
                msg = "Inserción correcta de la Mascota";
            }else  {
                msg ="Error en la insercion";
            }
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
