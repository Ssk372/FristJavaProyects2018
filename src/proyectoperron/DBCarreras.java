/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoperron;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Axel
 */
public class DBCarreras {
    public static void crearcarrera(Encapsulamiento e1)
    {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO carreras (Carrera) VALUES (?)";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setString(1, e1.getCarrera());
    ps.executeUpdate();
    ps.close();
    db.close();
    JOptionPane.showMessageDialog(null, "Agregado");
}
catch(SQLException ex)
{
    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());


}
    }
    public static List<Encapsulamiento> MostrarCarreras()
{
List <Encapsulamiento> Listas = new ArrayList<>();
   Conexion c1 =new Conexion();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM carreras";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    Encapsulamiento carrera = new Encapsulamiento();
    carrera.setId(resultSet.getInt("id"));
    carrera.setCarrera(resultSet.getString("carrera"));
    Listas.add(carrera);
    
    
    }
    ps.close();
    db.close();

}
catch(SQLException ex)
{
JOptionPane.showConfirmDialog(null,"error"+ ex.getMessage());

}
return Listas;
}
      public static List<Encapsulamiento> MostrarCarreras(int vid)
{
List <Encapsulamiento> Listas = new ArrayList<>();
   Conexion c1 =new Conexion();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM carreras WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    Encapsulamiento carrera = new Encapsulamiento();
    carrera.setId(resultSet.getInt("id"));
    carrera.setCarrera(resultSet.getString("carrera"));
    Listas.add(carrera);
    
    
    }
    ps.close();
    db.close();

}
catch(SQLException ex)
{
JOptionPane.showConfirmDialog(null,"error"+ ex.getMessage());

}
return Listas;
}
  public static boolean actualizaCarrera(Encapsulamiento e1)
  {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE carreras set Carrera=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getCarrera());
ps.setInt(2, e1.getId());
ps.executeUpdate();
ps.close();
db.close();
resultado=true;
}
catch(SQLException ex)
{

JOptionPane.showConfirmDialog(null,"error"+ ex.getMessage());

}
return resultado;
  }
  public static boolean Eliminarcarrera(int vid)
  {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM carreras WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setInt(1, vid);
ps.executeUpdate();
ps.close();
db.close();
resultado=true;
}
catch(SQLException ex)
{

JOptionPane.showConfirmDialog(null,"error"+ ex.getMessage());

}
return resultado;
  }
            
    }
