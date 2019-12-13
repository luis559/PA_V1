<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <!-- link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"-->
        <link rel="stylesheet" type="text/css" href="datatables_1.10.12/jquery.dataTables.min.css">
    </head>
    <body>
        <div class="container">
            <header>
                <h2>${message}</h2>

                Click para el siguiente modulo <strong><a href="/proveedores">Proveedores</a></strong> to visit another page.
                <br>
                <a href="https://datatables.net/examples/api/select_single_row.html">
                    https://datatables.net/examples/api/select_single_row.html
                </a>
            </header>
            <form method="post" >
                <label>Nombre</label>
                <input type="text" name="nombre" >
                <label>Descripción</label>
                <input type="text" name="descripcion" >
                <button type="button" onclick="save()"  >Guardar</button>
            </form>
            <h1>Productos</h1>
            <h2>Empleando los parámetros Model</h2>
            <div class="starter-template">
                <table class="table table-striped table-hover table-condensed table-bordered">
                    <tr>
                     <th>Id</th>
                     <th>Nombre</th>
                     <th>Descripción</th>
                    </tr>
                    
                    <c:forEach var="producto" items="${productos}">
                     <tr>
                      <td>${producto.id}</td>
                      <td>${producto.nombre}</td>
                      <td>${producto.descripcion}</td>
                     </tr>
                    </c:forEach>
                </table>
            </div>

            <h2>Empleando la rest Api</h2>
            <button id="btnDelete" type="button" >Borrar fila seleccionada</button>
            <div class="starter-template">
                <table id="productosTable" class="display">
                   <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>id</th>
                            <th>nombre</th>
                            <th>descripcion</th>
                        </tr>
                    </tfoot>
                </table>
            </div>

        </div>
        <!-- script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script -->
        <script src="jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="datatables_1.10.12/jquery.dataTables.min.js"></script>
        <script src="${contextPath}/resources/js/datatableproductos.js"></script>
        <script>
            /*
            (function ($) {
                $.fn.serializeFormJSON = function () {
                    var o = {};
                    var a = this.serializeArray();
                    $.each(a, function () {
                        if (o[this.name]) {
                            if (!o[this.name].push) {
                                o[this.name] = [o[this.name]];
                            }
                            o[this.name].push(this.value || '');
                        } else {
                            o[this.name] = this.value || '';
                        }
                    });
                    return o;
                };
            })(jQuery);
            */
                function save() {
                    var urlport = "${site_urlport}";
                    var dataForm = JSON.stringify( $("form").serializeArray().reduce( (f,c) => { f[c.name]=c.value; return f;}, {} ) ) ;
                    console.log( dataForm );
                    console.log (urlport);
                    $.ajax({
                        //url: urlport + "/api/productos", // verificar si se utiliza la ruta y puerto desde application.properties
                        url: "/api/productos",
                        type: 'POST', dataType: 'json',
                        contentType: "application/json; charset=utf-8",
                        data: dataForm,
                        success: function(data) {
                            console.log ( data.nombre );
                            //$('#productosTable').dataTable().fnClearTable(); // borrar todo
                            $('#productosTable').dataTable().fnAddData(data);
                        }, 
                        error: function( jqXHR, textStatus, errorThrown ) {
                            alert ("error: " + textStatus );
                        }
                    }).fail( function( jqXHR, textStatus, errorThrown ) {
                        alert ("fail: " + textStatus );
                    });
                }

                $(document).ready(function() {
                    var table = $('#productosTable').DataTable();
                    $('#productosTable tbody').on( 'click', 'tr', function () {
                        if ( $(this).hasClass('selected') ) {
                            $(this).removeClass('selected');
                        }
                        else {
                            table.$('tr.selected').removeClass('selected');
                            $(this).addClass('selected');
                        }
                    } );
                    $('#btnDelete').click( function () {
                        // hacer el borrado visual
                        table.row('.selected').remove().draw( false );
                    } );
                } );                
        </script>
    </body>

</html>
