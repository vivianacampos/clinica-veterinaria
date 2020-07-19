<%-- 
    Document   : listar
    Created on : 10-07-2020, 21:02:13
    Author     : Viviana Campos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body class="purple lighten-5">
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <jsp:include page="nav.jsp" />  
                </div>
            </div>
            <div class="row">
                <div class="col s8 offset-s2 card-panel z-depth-5">
                    <p class="center-align">Seleccione una opción a buscar</p>
                    <form action="/buscar.do" method="get">
                        <div style="margin: 20px 0 0 90px" class="input-field col s6">
                            <select>
                                <option value="" disabled selected>Seleccionar</option>
                                <option value="1">Mascotas</option>
                                <option value="2">Medico Veterinario</option>
                                <option value="3">Enfermedad</option>
                            </select>
                        </div>
                        
                        <button style="margin: 30px 0 0 20px" name="btnListar" value="" type="submit" class="btn left-align">
                            Buscar
                        </button>

                    <table class="bordered highlight">
                        <tr>
                            <th>Nombre</th>
                            <th>Especie</th>
                            <th>Raza</th>
                            <th>Edad</th>
                            <th>Fecha Nac</th>
                            <th>Sexo</th>
                          
                        </tr>
                        <c:forEach items="${requestScope.listaMasc}" var="mas">
                            <tr>
                                <td>${mas.nombre}</td>
                                <td>${mas.especie}</td>
                                <td>${mas.raza}</td>
                                <td>${mas.edad}</td>
                                <td>${mas.fnac}</td>
                                <td>${mas.sexo}</td>
                            </tr>    
                        </c:forEach>
                    </table>
                        
                        
                        
                        
                        
                        
                    </form>
                </div>
            </div>




        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $(".button-collapse").sideNav();
            });
        </script>
        <script>
            $(document).ready(function () {
                $('select').material_select();
            });
        </script>
    </body>
</html>
