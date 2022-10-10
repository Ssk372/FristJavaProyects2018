/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoperron;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Axel
 */
public class Conexion {
    public static String server = "jdbc:mysql://localhost:3306/tabla";
     public static String user="root";
     public static String password="";
       public static Connection conectar(){
           Connection connection = null;
           
       try{
       connection=DriverManager.getConnection(server,user,password);
       JOptionPane.showMessageDialog(null, "conexion exitosa");
       } catch(Exception ex)
       {
       JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
       }
       return connection;
       }
     
}
