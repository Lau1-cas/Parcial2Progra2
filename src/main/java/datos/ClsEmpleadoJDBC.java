/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import Dominio.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author USUARIO
 */
public class ClsEmpleadoJDBC {
    
    private static final String SQL_SELECT ="select * from tb_empleados";
    private static final String SQL_INSERT ="insert into tb_empleados (nombre,enero,febrero,marzo) values(?,?,?,?)";
    private static final String SQL_UPDATE ="update tb_empleados set nombre =?,enero =?,febrero=?, marzo=? where ID=?";
    private static final String SQL_DELETE="delete from tb_empleados where ID=? ";
    
    
    
    //Seleccionar informacion
    public List<ClsEmpleado> seleccion(){
    
    Connection conn=null;
    PreparedStatement stmt=null;
    ResultSet rs= null;
    ClsEmpleado empleado=null;
    List <ClsEmpleado> empleados=new ArrayList<ClsEmpleado>();
    
        try {
            conn= ClsConexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            
            while(rs.next()){
            int ID =rs.getInt("ID");
            String nombre =rs.getString("nombre");
            int enero =rs.getInt("enero");
            int febrero =rs.getInt("febrero");
            int marzo =rs.getInt("marzo");
             empleado=new ClsEmpleado();
            
            empleado.setID(ID);
            empleado.setNombre(nombre);
            empleado.setEnero(enero);
            empleado.setFebrero(febrero);
            empleado.setMarzo(marzo);
            empleados.add(empleado);
            }
        } catch (SQLException ex) {
          ex.printStackTrace(System.out);
        }
    finally {
        ClsConexion.close(rs);
        ClsConexion.close(stmt);
        ClsConexion.close(conn);
        
        }
        return empleados;
    }
    
    //Seleccionar informacion
    public int insert(ClsEmpleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNombre());
            stmt.setInt(2, empleado.getEnero());
            stmt.setInt(3, empleado.getFebrero());
            stmt.setInt(4, empleado.getMarzo());
         
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;
    }


public int actualizar(ClsEmpleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(5, empleado.getID());
            stmt.setString(1, empleado.getNombre());
            stmt.setInt(2, empleado.getEnero());
            stmt.setInt(3, empleado.getFebrero());
            stmt.setInt(4, empleado.getMarzo());
            
            
            System.out.println("ejecutando query:" + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;
    }
public int eliminar(ClsEmpleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getID());
           
            System.out.println("ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{

            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;
    }
}

