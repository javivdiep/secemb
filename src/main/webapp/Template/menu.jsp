<%-- 
    Document   : menu
    Created on : 11 dic. 2023, 10:09:40
    Author     : javivdiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <!-- <nav class="navbar navbar-dark bg-dark"> -->
        <nav class="navbar navbar-dark bg-dark">
            <div class="opciones-menu">
                <a style="color: white" class="navbar-toggler" active" href="Principal.jsp"><span class="navbar-toggler-icon"></span> Home</a>
              
                <a style="color: white" class="opciones-menu active" href="Alumnos.jsp">Alumnos</a>

                <a style="color: white" class="opciones-menu active" href="Usuarios.jsp">Usuarios</a>

                <a style="color: white" class="opciones-menu disabled" aria-disabled="true">Configuracion</a>

            </div>
            <div class="dropdown">
                <a style="color:white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" >
                     Cerrar Sesion
                </a>
                <div class="dropdown-menu text-center">
                    <a><img src="img/usr_m.png" height="80" width="80"></a><br>
                    <a>${nombres}</a><br>
                    <a>${correo}</a>
                    <div class="dropdown-divider"></div>
                    <a href="index.jsp" class="dropdown-item">Salir</a>
                </div>
            </div>
        </nav>
           



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>        

