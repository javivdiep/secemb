<%-- 
    Document   : index
    Created on : 10 dic. 2023, 16:22:14
    Author     : javivdiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert2/11.10.4/sweetalert2.min.css" integrity="sha512-OWGg8FcHstyYFwtjfkiCoYHW2hG3PDWwdtczPAPUcETobBJOVCouKig8rqED0NMLcT9GtE4jw6IT1CSrwY87uw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>  
        <title>CEMB Page</title>
    </head>
    <body>
    <center><h1>Sistema Escolar WEB</h1></center>
          
        <div class="container col-lg-3">
              <!-- <form action="Controlador" method="post"> -->
              <form onsubmit="return verificarCaptcha();" action="Controlador" method="post">
              <div class="form-group text-center">    
                <img src="img/logoCEMB.jpg" alt="35" width="85"/>
                    <p><strong>Bienvenidos al Sistema</strong></p>
                </div>
                <div class="form-group">
                    <label>Usuario:</label>
                    <p><input class="form-control" type ="text" name="txtuser" placeholder="Ingrese nombre"></p>
                </div>
                <div class="form-group">
                    <label>Correo:</label>
                    <p><input type="email" name="txtcorreo" placeholder="example@gmail.com" class="form-control"></p>
                </div>
                <div class="g-recaptcha" data-sitekey="6LeXnFEpAAAAACDzqfZ7AfJTUHHw7DgjauwepZdv" data-callback="verifyCaptcha" ></div>
                <div id="g-recaptcha-error"></div>
                <input type="submit" name="accion" value="Ingresar" class="btn btn-danger btn-block">
                
            </form>
           
            <script>
                $(document).ready(function(){
                    $('#entrar').click(function(){
                        grecaptcha.ready(funcion(){
                            grecaptcha.execute("6LeXnFEpAAAAACDzqfZ7AfJTUHHw7DgjauwepZdv", {
                                action: 'validarUsuario'
                            }).then(function(token){
                                //Add your logic to submit to your backend server here.
                                $
                            });
                        });
                    })
                })
            </script>
        </div>
    <script>
    
    function verificarCaptcha(a){
        var response = grecaptcha.getResponse();

    if(response.length == 0){
        alert("Captcha no verificado");
//        $(document).ready(function(){
//            Swal.fire({
//            title: "Validación de usuario",
//            text: "Captcha no verificado",
//            icon: "error"
//            });
//        })
        return false;
        event.preventDefault();
    } else {
      /*alert("Captcha verificado");*/
//      $(document).ready(function(){
//            Swal.fire({
//            title: "Validación de usuario",
//            text: "Captcha verificado",
//            icon: "success"
//            timer: 1500
//            });
//        })
      return true;
    }
    }
   
    </script>
    <script src="js/enabledSubmit.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert2/11.10.4/sweetalert2.all.min.js" integrity="sha512-lTaUIREPGkPIN75aQtSK7bEt6w/YhlsMjWhhJ0X2LNTXySpI10ZPsz+lmcuz2BP7/WGBjAwbnavUhK4Yb3X13Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
