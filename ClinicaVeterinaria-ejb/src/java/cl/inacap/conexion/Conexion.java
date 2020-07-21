/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Viviana Campos
 */
public class Conexion {

    private final String user = "system";
    private final String pass = "lexy21";
    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
   
    
    public Connection getConexion() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println( "Conexion Erronea" + e.getMessage());
        }
        return DriverManager.getConnection(url, user, pass);
        
        
       
    }
    
}
