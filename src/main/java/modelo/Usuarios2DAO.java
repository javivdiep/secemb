/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author javivdiep
 */
public class Usuarios2DAO extends Conexion{
    public int insertarUsuarios(Usuarios u) throws ClassNotFoundException{
        int res=0;
        try{
            this.conectar();
            System.out.println("Se contectó dentro de insertarUsuarios");
            String sql="INSERT INTO Usuarios(nombres,apellidos,telefono,estado,correo) VALUES (?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,u.getNombres());
            pre.setString(2,u.getApellidos());
            pre.setString(3,u.getTelefono());
            pre.setString(4,u.getEstado());
            pre.setString(5,u.getCorreo());
            res=pre.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al insertar Usuarios"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return res;
    }
    
    public ArrayList<Usuarios> mostrarUsuarios() throws ClassNotFoundException{
        ArrayList<Usuarios> lista = new ArrayList<>();
        
        try{
            this.conectar();
            System.out.println("Se contectó dentro de mostrarUsuarios");
            /*String sql ="SELECT * FROM Usuarios us INNER JOIN Roles ro on us.estado=ro.id where ro.id=2";*/
            String sql ="SELECT * FROM Usuarios us INNER JOIN Roles ro on us.estado=ro.id";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                Usuarios u = new Usuarios();
                u.setId(rs.getInt(1));
                u.setNombres(rs.getString(2));
                u.setApellidos(rs.getString(3));
                u.setTelefono(rs.getString(4));
                u.setEstado(rs.getString(5));
                u.setDescripcionrol(rs.getString(8));
                u.setCorreo(rs.getString(6));
                
                lista.add(u);
                
            }
            
        }catch (SQLException e){
            System.out.println("Error al mostrar Usuarios"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
    public int modificarUsuarios(Usuarios u) throws ClassNotFoundException{
        int res=0;
        try{
            this.conectar();
            String sql="UPDATE Usuarios SET nombres=?, apellidos=?, telefono=?, estado=?, correo=? WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            /*pre.setInt(1,u.getId());*/
            pre.setString(1,u.getNombres());
            pre.setString(2,u.getApellidos());
            pre.setString(3,u.getTelefono());
            pre.setString(4,u.getEstado());
            pre.setString(5,u.getCorreo());
            pre.setInt(6, u.getId());
            res=pre.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al modificar Usuarios"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return res;
        
    }
    
    public int eliminarUsuarios(Usuarios u) throws ClassNotFoundException{
        int res=0;
        try{
            this.conectar();
            String sql="DELETE FROM Usuarios WHERE id=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, u.getId());
            res=pre.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error al eliminar Usuarios"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return res;
    }

public void usuarioservlet(String usuario, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

public void controlador(String nombres, String apellidos, String telefono, String estado, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}