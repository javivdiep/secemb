/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author javivdiep
 */
public class Usuarios {
    int id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String estado;
    private String correo;
    private String descripcionrol;
    private String ruta;
    /*Se puede agregar otro estado int para el id del rol*/
    

     public Usuarios() {
        
    }
     
    public Usuarios(int id, String nombres, String apellidos, String telefono, String estado, String correo, String descripcionrol, String ruta) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.estado = estado;
        this.correo = correo;
        this.descripcionrol = descripcionrol;
        this.ruta = ruta;
    }

    public Usuarios(int id, String nombres, String apellidos, String telefono, int estado, String correo, String descripcionrol, String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getDescripcionrol() {
        return descripcionrol;
    }

    public void setDescripcionrol(String descripcionrol) {
        this.descripcionrol = descripcionrol;
    }
    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
