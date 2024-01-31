/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author javivdiep
 */
public class Conexion {
    
    private Connection con;
    //String url="jdbc:mysql://localhost:3306/bdescuela";
    String url="jdbc:mysql://74.208.247.197:3306/bdescuela";
    String user="root";
    //String pass="=NanJav1412";
    String pass="Am@t3Studi0s201!";
    public Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            /*con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdescuela","root","=NanJav1412");*/
             System.out.println("Se conectó a MySQL: ");
        }catch (SQLException e){
            System.out.println("No se conectó a MySQL: "+e.toString());
        }
        return con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch (SQLException e){
            System.out.println("Se conectó a MySQL: "+e.toString());
        }
    }
    
    public void desconectar(){
        try{
            if(!con.isClosed())
                con.close();
        }catch (SQLException e){
            System.out.println("Error al cerra la conexion a MySQL: "+e.toString());
        }   
    
    }
}
