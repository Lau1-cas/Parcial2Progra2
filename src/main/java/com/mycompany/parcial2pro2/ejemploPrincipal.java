/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcial2pro2;
import Dominio.ClsEmpleado;
import datos.ClsEmpleadoJDBC;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class ejemploPrincipal {
    public static void ej1(){
    
        //paso 1: definir string de conexion
    String url = "jdbc:mysql://localhost:3306/bd_empleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
    
        try {
            //paso2 crear el objeto de conexion

            Connection conexion=DriverManager.getConnection(url, "root", "Holamundo1");
            
            
            //PASO 3 crear el obj statement
            Statement sentencia =conexion.createStatement();
            
            
            //PASO4 CREAR LA INSTRUCCION SQL
            String sql="select * from tb_empleados";
            
            //paso5 ejecutamos el query
            
            ResultSet resultado =sentencia.executeQuery(sql);
            
            
            //PASO 6 RECORRER EL RESULTADO
            while(resultado.next()){
            
          System.out.println("id= "+resultado.getInt(1));
          System.out.println("nombre= "+resultado.getString(2));
          System.out.println("enero= "+resultado.getInt(3));
          System.out.println("febrero= "+resultado.getInt(4));
          System.out.println("marzo= "+resultado.getInt(5));
            
            }
            conexion.close();
            
                    } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    
    
    }
    public static void main (String [] args){
    
   // ej1();
    ClsEmpleadoJDBC alJDBC= new ClsEmpleadoJDBC();
    
    
    ClsEmpleado nuevo= new ClsEmpleado();
    
     //REMPLAZAR
   // nuevo.setID(4);
   // nuevo.setNombre("DORI CANELA BOTEO FLORES");
   // nuevo.setEnero(300);
    //nuevo.setFebrero(100);
   // nuevo.setMarzo(500);
    //alJDBC.actualizar(nuevo);
    
   //Ingresar nueva información
    //nuevo.setNombre("ROSAURA AMABILIA PINEDA");
   // nuevo.setEnero(800);
    //nuevo.setFebrero(3600);
    //nuevo.setMarzo(150);
    
  //alJDBC.insert(nuevo);
    
    //ELIMINAR
    nuevo.setID(5);
    nuevo.setNombre("ROSAURA AMABILIA PINEDA");
   nuevo.setEnero(800);
    nuevo.setFebrero(3600);
    nuevo.setMarzo(150);
    
    
    alJDBC.eliminar(nuevo);
    
    
    //Seleccionar informacion
    List<ClsEmpleado> todos= alJDBC.seleccion();
    
    for (ClsEmpleado empleado : todos){
    
    System.out.println("Empleado= "+empleado);
    
    }
    
    } 
}
