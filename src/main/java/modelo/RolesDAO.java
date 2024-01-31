/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author javivdiep
 */
public class RolesDAO extends Conexion{

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
        
    public ArrayList<Roles> mostrarRoles(){
       ArrayList<Roles> lista = new ArrayList<>();
       
       try {
           this.conectar();
           String sql ="Select * from Roles";
           PreparedStatement pre = this.getCon().prepareStatement(sql);
          
           ResultSet rs;
           rs = pre.executeQuery();
           while(rs.next()){
               Roles r = new Roles();
               r.setId(rs.getInt(1));
               r.setRol(rs.getString(2));
               r.setDescripcion(rs.getString(3));
               lista.add(r);
           }
       }catch(Exception e){
           System.out.println("Error al mostrar Roles "+e.getMessage());
       }finally{
           this.desconectar();
       }
       return lista;
    }

    
    
}
