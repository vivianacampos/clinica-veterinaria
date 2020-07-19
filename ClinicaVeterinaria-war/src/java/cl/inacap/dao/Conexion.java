/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Viviana Campos
 */
public class Conexion {
    private final String user = "system";
    private final String pass = "lexy21";
    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    
    public Connection getConexion() throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(url, user, pass);
    }
    
}
