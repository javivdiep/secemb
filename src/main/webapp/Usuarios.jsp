<%-- 
    Document   : Usuarios
    Created on : 11 dic. 2023, 10:04:55
    Author     : javivdiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<%@page import="modelo.Roles" %>
<%@page import="modelo.RolesDAO" %>
<%@page import="modelo.Usuarios" %>
<%@page import="modelo.Usuarios2DAO" %>

<%@page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.8/css/dataTables.bootstrap5.min.css" >
        
        <title>Usuarios SECEMB</title>
    </head>
    <body>
        <%!  
            RolesDAO rolesDAO=new RolesDAO();
            Usuarios2DAO usuarios2DAO=new Usuarios2DAO();
        %>
        <div class="container">
            <%@include file="Template/menu.jsp"%>
            <hr>
            <div class="row" align-items-start>
                <div class="col-9"><h2>Usuarios</h2></div>
                <div class="col-3 align-self-center"> <button type="button" class="btn btn-success btnAdd" data-bs-toggle="modal" data-bs-target="#Modal">Agregar</button></div>
            </div>
           
            <hr>
            <div class="table-responsive">
                <table class="table table-striped" id="mydataTable">
                    <thead>
                        <th>id</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Teléfono</th>
                        <th>Estado</th>
                        <th>Correo</th>
                        <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%
                        ArrayList<Usuarios> listaUsuarios = usuarios2DAO.mostrarUsuarios();
                        
                        for (Usuarios elem : listaUsuarios){    
                            
                        %>
                        <tr>
                            <td class="id"><%= elem.getId() %></td>
                            <td class="nombres"><%= elem.getNombres() %></td>
                            <td class="apellidos"><%= elem.getApellidos() %></td>
                            <td class="telefono"><%= elem.getTelefono() %></td>
                            <td class="estado"><%= elem.getDescripcionrol() %></td>
                            <td class="correo"><%= elem.getCorreo() %></td>
                            <td>
                                <button type="button" class="btn btn-dark btnEditar" data-bs-toggle="modal" data-bs-target="#Modal">Editar</button>
                                <button type="button" class="btn btn-danger btnEliminar" data-bs-toggle="modal" data-bs-target="#Modal">Eliminar</button>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                    
                </table>
            </div>
        
        </div>
            
    <!-- Button trigger modal dentro de Agregar arriba-->

        <!-- Modal -->
        <div class="modal fade" id="Modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Usuarios</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <form action="${pageContext.servletContext.contextPath}/Controlador" method="POST" role="form">
                      
                  <!--<form action="controlador/Usuario" method="POST">-->
                      <div class="row">
                          <div class="col-6">
                              <label>Id</label>
                              <input type="text" name="txtId" class="form-control" id="txtId" value=0 readonly="true">
                          </div>
                      </div>
                      <div class="row">
                          <div class="col-6">
                              <label>Nombres</label>
                              <input type="text" name="txtNombres" class="form-control" id="txtNombres">
                          </div>
                      </div>
                      <div class="row">
                          <div class="col-6">
                              <label>Apellidos</label>
                              <input type="text" name="txtApellidos" class="form-control" id="txtApellidos">
                          </div>
                      </div>
                      <div class="row">
                          <div class="col-6">
                              <label>Telefono</label>
                              <input type="text" name="txtTelefono" class="form-control" id="txtTelefono">
                          </div>
                      </div><br>
                      <div class="row">
                          <div class="col-6">
                              <label>Rol</label><br>
                              <select name="txtRol" id="txtRol" class="form-select">
                                  <option value="">Seleccionar Rol ...</option>
                                  <%
                                    ArrayList<Roles> lista = rolesDAO.mostrarRoles();
                                    for (Roles elem : lista){
                                
                                  %>
                                  <option value="<%= elem.getId() %>"><%= elem.getRol()  %></option>
                                  <%
                                      }
                                  %>
                                 
                              </select>
                          </div>
                    </div><br>
                    <div class="row">
                          <div class="col-6">
                              <label>Correo</label>
                              <input type="email" name="txtCorreo" placeholder="example@gmail.com" class="form-control" id="txtCorreo">
                          </div>
                    </div><br>
                    <div class="row">
                          <div class="col-6">
                              <label>Imagen</label>
                              <input type="file" name="fileImagen" id="fileImagen">
                          </div>
                    </div><br>
                    <div class="row">
                        <div class="col-12">
                            <button type="submit" name="accion" value="Guardar" class="btn btn-success btnOcultar1">Guardar</button>
                            <button type="submit" name="accion" value ="Editar" class="btn btn-dark btnOcultar">Editar</button>
                            <button type="submit" name="accion" value="Eliminar" class="btn btn-danger btnOcultar">Eliminar</button> 
                            <button type="button" class="btn btn-info" data-bs-dismiss="modal">Cancelar</button>
                        </div>
                    </div>
                            
                </form>
             
               </div>
            </div>
                      
                   
          </div>
          <div class="modal-footer">
                
          </div>
        </div> <!-- Cierre de modal -->
        
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.13.8/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.8/js/dataTables.bootstrap5.min.jsv"></script>
        
        <%
            if(request.getAttribute("message") != null){
            
        %>
        <script>alert('<%= request.getAttribute("message") %>');</script>
        <%
            }
        %>
        <script src="${pageContext.servletContext.contextPath}/js/usuario.js"></script>
    </body>
</html>
