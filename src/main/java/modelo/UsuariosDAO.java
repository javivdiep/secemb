/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author javivdiep
 */
public class UsuariosDAO implements Validar{

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    

 
    @Override
    public int validar(Usuarios usr){
        int r=0;
        String sql="select * from Usuarios where correo=? and nombres=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, usr.getCorreo());
            ps.setString(2,usr.getNombres());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                usr.setId(rs.getInt("id"));
                usr.setNombres(rs.getString("nombres"));
                usr.setApellidos(rs.getString("apellidos"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setEstado(rs.getString("estado"));
                usr.setCorreo(rs.getString("correo"));
            } 
            if (r==1){
                System.out.println("Exito: 1 ");
                
                return 1;
            }else{
                System.out.println("Falla: 0");
                return 0;
            }
        }catch (Exception e){
            System.out.println("Fallo:try "+ e.toString());
            return 0;
        }
    }

    public void controlador(String usuario, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}

