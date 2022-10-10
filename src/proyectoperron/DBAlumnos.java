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
public class DBAlumnos {
    
    public static void crearalumnno(Encapsulamiento2 e1)
    {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO alumnos (Nombres, Apellidos, Matricula, Correo, Edad, Direccion, Carrera_ID) VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setString(1, e1.getNombre());
    ps.setString(2, e1.getApellidos());
    ps.setInt(3, e1.getMatricula());
    ps.setString(4, e1.getCorreo());
    ps.setInt(5, e1.getEdad());
    ps.setString(6, e1.getDireccion());
    ps.setInt(7, e1.getId());
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
    public static List<Encapsulamiento2> MostrarAlumnos()
{
List <Encapsulamiento2> Listas = new ArrayList<>();
   Conexion c1 =new Conexion();
Connection db = c1.conectar();

try{

    String consulta = "SELECT a1.ID, a1.Nombres, a1.Apellidos, a1.Matricula, a1.Correo,a1.Edad, a1.Direccion, c1.Carrera FROM alumnos a1 INNER JOIN carreras c1 ON a1.Carrera_ID = C1.ID";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    Encapsulamiento2 alumno = new Encapsulamiento2();
    alumno.setId(resultSet.getInt("ID"));
    alumno.setNombre(resultSet.getString("Nombres"));
    alumno.setApellidos(resultSet.getString("Apellidos"));
       alumno.setMatricula(resultSet.getInt("Matricula"));
          alumno.setCorreo(resultSet.getString("Correo"));
             alumno.setEdad(resultSet.getInt("Edad"));
                alumno.setDireccion(resultSet.getString("Direccion"));
                alumno.setCarrera(resultSet.getString("Carrera"));
    Listas.add(alumno);
    
    
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
      public static List<Encapsulamiento2> MostrarAlumno(int vid)
{
List <Encapsulamiento2> Listas = new ArrayList<>();
   Conexion c1 =new Conexion();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM alumnos WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     Encapsulamiento2 alumno = new Encapsulamiento2();
    alumno.setId(resultSet.getInt("ID"));
    alumno.setNombre(resultSet.getString("Nombres"));
    alumno.setApellidos(resultSet.getString("Apellidos"));
       alumno.setMatricula(resultSet.getInt("Matricula"));
          alumno.setCorreo(resultSet.getString("Correo"));
             alumno.setEdad(resultSet.getInt("Edad"));
                alumno.setDireccion(resultSet.getString("Direccion"));
                   alumno.setCarreraid(resultSet.getInt("Carrera_ID"));
            
    Listas.add(alumno);
    
    
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
  public static boolean actualizarAlumnos(Encapsulamiento2 e1)
  {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE alumnos set Nombres=?, Apellidos=?, Matricula=?, Correo=?, Edad=?, Direccion=?, Carrera_ID=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getNombre());
    ps.setString(2, e1.getApellidos());
    ps.setInt(3, e1.getMatricula());
    ps.setString(4, e1.getCorreo());
    ps.setInt(5, e1.getEdad());
    ps.setString(6, e1.getDireccion());
    ps.setInt(7, e1.getCarreraid());
    ps.setInt(8, e1.getId());
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
  public static boolean Eliminaralumno(int vid)
  {
    Conexion c1 =new Conexion();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM alumnos WHERE ID=?";
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
