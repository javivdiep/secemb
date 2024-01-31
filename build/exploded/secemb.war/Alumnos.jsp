<%-- 
    Document   : Alumnos
    Created on : 11 dic. 2023, 11:58:04
    Author     : javivdiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Alulmos SECEMB</title>
    </head>
    <body>
        <div class="container">
            <%@include file="Template/menu.jsp"%>
            <h2>Alumnos</h2>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped">
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
                        <tr>
                            <td>1</td>
                            <td>Javiv</td>
                            <td>Diep</td>
                             <td>5564931499</td>
                            <td>1</td>
                            <td>javivdiep@gmail.com</td>
                            <td>
                                <button type="button" class="btn btn-dark">Editar</button>
                                <button type="button" class="btn btn-danger">Eliminar</button>
                            </td>
                        </tr>
                    </tbody>
                    
                </table>
            </div>
            
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
