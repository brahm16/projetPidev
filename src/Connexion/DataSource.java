/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DataSource {
    private String url="jdbc:mysql://localhost:3306/projet_pidev";
    private String user="root";
    private String password="";
    private Connection con;
    private static DataSource instance;

    private DataSource() {
        try {
            con=DriverManager.getConnection(url,user,password);
            System.out.println("connexion r�ussi");

        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DataSource getInstance()
    {
        if(instance==null)
            instance=new DataSource();
        return instance;
    }

    public Connection getCon() {
        return con;
    }
    
}
