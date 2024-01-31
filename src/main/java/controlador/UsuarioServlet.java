/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;  /*-USUARIOS SERVLET-*/

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuarios;
import modelo.Usuarios2DAO;



/**
 *
 * @author javivdiep
 */
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        /*String accion=request.getParameter("btnGuardar");
        if(accion.equals("Guardar")){*/
        System.out.println("Entro al UsuarioServlet");
            
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
        String ruta="";
        
        Usuarios u = new Usuarios(id,nombres,apellidos,telefono,estado,correo,descripcionrol,ruta);
        Usuarios2DAO usuariosDAO = new Usuarios2DAO();
        
        System.out.println("Antes de entrar a btnGuardar");
        if(request.getParameter("btnGuardar") != null) {
            System.out.println("Despues de btnGuardar");    
            res=usuariosDAO.insertarUsuarios(u);
                if(res != 0){
                    System.out.println("Registro Agregado");
                    mensaje = "Registro Agregado";
                }
        }
        
        request.setAttribute("message",mensaje);
        request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        

        }catch(Exception e){
                System.out.println("Error "+e.getLocalizedMessage());
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
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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

