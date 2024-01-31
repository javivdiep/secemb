/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
/*
const table = document.getElementById('Table');
const modal = document.getElementById('Modal');

table.addEventListener('click',(e)=>{
    e.stopPropagation();
    console.log(e.target);
});
*/

function cargarFormulario(fila){
    var id = $(fila).find(".id").text();
    var nombres = $(fila).find(".nombres").text();
    var apellidos = $(fila).find(".apellidos").text();
    var telefono = $(fila).find(".telefono").text();
    var estado = $(fila).find(".estado").text();
    var correo = $(fila).find(".correo").text();
    
    $("#txtId").val(id);
    $("#txtNombres").val(nombres);
    $("#txtApellidos").val(apellidos);
    $("#txtTelefono").val(telefono);
    $("#txtRol option[selected]").removeAttr('selected');
    $("#txtRol option:contains("+estado+")").attr('selected', true);
    $("#txtCorreo").val(correo);
    
}

 $(document).ready(function (){
        new DataTable('#mydataTable');
        
       // Limpiar Modal 
       $("#Modal").on("hidden.bs.modal", function(){
           $('form')[0].reset(); 
           $("#txtRol option[selected]").removeAttr('selected'); //Limpiar Rol
        });
       
       //Llenar Modal Editar
        $(document).on('click','.btnEditar',function(){
            cargarFormulario($(this).closest('tr'));
            $('.btnOcultar1').attr('disabled','disabled');
            $('.btnOcultar').removeAttr('disabled');
        });
        
        //Llenar Modal Eliminar
        $(document).on('click','.btnEliminar',function(){
            cargarFormulario($(this).closest('tr'));
            $('.btnOcultar1').attr('disabled','disabled');
            $('.btnOcultar').removeAttr('disabled');
        });
        
        //Llenar Modal
        $(document).on('click','.btnAdd',function(){
            $('.btnOcultar').attr('disabled','disabled');
            $('.btnOcultar1').removeAttr('disabled');
        });
    });


