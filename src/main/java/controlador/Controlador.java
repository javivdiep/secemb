/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuarios;
import modelo.Usuarios2DAO;
import modelo.UsuariosDAO;
import modelo.Validar;


/**
 *
 * @author javivdiep
 */
public class Controlador extends HttpServlet {
    
    /*UsuariosDAO dao=new UsuariosDAO();*/
    
    Validar dao=new UsuariosDAO();
    Usuarios u=new Usuarios();
    int id;
    String apellidos;
    String telefono;
    int estado;
    int r;
    String mensaje="Error";
    String ruta;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion=request.getParameter("accion");
        
        
        if(accion.equals("Ingresar")){
            String usuario=request.getParameter("txtuser");
            String correo=request.getParameter("txtcorreo");
            System.out.println("Usuario recibido desde index: " + usuario);
            System.out.println("Email recibido desde index: " + correo);
           
            u.setNombres(usuario);
            u.setCorreo(correo);
            
            System.out.println("Usuario u: " + u.getNombres());
            System.out.println("Email u: " + u.getCorreo());
            
            r=dao.validar(u);
            if(r==1){
                request.getSession().setAttribute("id",id);
                request.getSession().setAttribute("nombres",usuario);
                request.getSession().setAttribute("apellidos", apellidos);
                request.getSession().setAttribute("telefono", telefono);
                request.getSession().setAttribute("estado", estado);
                request.getSession().setAttribute("correo",correo);
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }else
                request.getRequestDispatcher("index.jsp").forward(request, response);
            
        
        }else{    
            System.out.println("Desde Usurios.jsp " + accion);
            try (PrintWriter out = response.getWriter()) {
            //Captura de datos
            int id = Integer.parseInt(request.getParameter("txtId"));
            String nombres = request.getParameter("txtNombres");
            String apellidos = request.getParameter("txtApellidos");
            String telefono = request.getParameter("txtTelefono");
            /*int estado = Integer.parseInt(request.getParameter("txtRol"));*/
            String estado = request.getParameter("txtRol");
            String correo = request.getParameter("txtCorreo");
            String descripcionrol = request.getParameter("txtDescripcionrol");
        
            String mensaje="Error";
            int res;
        
        
            Usuarios u = new Usuarios(id,nombres,apellidos,telefono,estado,correo,descripcionrol,ruta);
            Usuarios2DAO usuariosDAO = new Usuarios2DAO();
            
            if(accion.equals("Guardar")){
            res=usuariosDAO.insertarUsuarios(u);
                if(res != 0){
                    System.out.println("Registro Agregado");
                    mensaje = "Registro Agregado";
                }
            }
            else if(accion.equals("Editar")){
                res=usuariosDAO.modificarUsuarios(u);
                if(res != 0){
                    System.out.println("Registro Modificado");
                    mensaje = "Registro Modificado";
                }
            }else if(accion.equals("Eliminar")){
                res=usuariosDAO.eliminarUsuarios(u);
                if(res != 0){
                    System.out.println("Registro Eliminado");
                    mensaje = "Registro Eliminado";
                }    
            }else if(accion.equals("CargarArchivo")){
                ArrayList<String>lista=new ArrayList<>();
                //ServletFileUpload fileUpload=new ServletFileUpload(file);
            }
        System.out.println("Mensaje " + mensaje);
        request.setAttribute("message",mensaje);
        request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        

        }catch(Exception e){
                System.out.println("Error "+e.getLocalizedMessage());
        } 
        
    }
    }

        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
