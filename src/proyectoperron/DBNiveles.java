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
public class DBNiveles {
    public static void crearnivel(Encapsulamiento3 e1)
    {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();   

try {
     String consulta= "INSERT INTO niveles (Descripcion) VALUES (?)";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setString(1, e1.getNombre());
  
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
    public static List<Encapsulamiento3> MostrarNiveles()
{
List <Encapsulamiento3> Listas = new ArrayList<>();
   Conexion c1 =new Conexion();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM niveles";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    Encapsulamiento3 niveles = new Encapsulamiento3();
    niveles.setId(resultSet.getInt("ID"));
    niveles.setNombre(resultSet.getString("Descripcion"));
   
    Listas.add(niveles);
    
    
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
      public static List<Encapsulamiento3> MostrarNivel(int vid)
{
List <Encapsulamiento3> Listas = new ArrayList<>();
   Conexion c1 =new Conexion();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM niveles WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     Encapsulamiento3 niveles = new Encapsulamiento3();
    niveles.setId(resultSet.getInt("ID"));
    niveles.setNombre(resultSet.getString("Descripcion"));
  
    Listas.add(niveles);
    
    
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
  public static boolean actualizarnivel(Encapsulamiento3 e1)
  {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE niveles set Descripcion=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getNombre());
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
  public static boolean Eliminarnivel(int vid)
  {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM niveles WHERE ID=?";
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
