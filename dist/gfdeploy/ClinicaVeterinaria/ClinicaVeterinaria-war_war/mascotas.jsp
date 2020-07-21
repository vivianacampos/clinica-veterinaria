<%-- 
    Document   : agregar
    Created on : 22-06-2020, 17:46:49
    Author     : Viviana Campos
--%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="cl.inacap.bean.ContadorConsultasLocal"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Declaración del EJB en el JSP -->
<%! ContadorConsultasLocal contadorConsultas;%>
<%
    InitialContext c = new InitialContext();
    contadorConsultas = (ContadorConsultasLocal) c.lookup("java:global/ClinicaVeterinaria/ClinicaVeterinaria-ejb/ContadorConsultas!cl.inacap.bean.ContadorConsultasLocal");
%>
<c:set var="consul" value="<%= contadorConsultas%>" scope="page" />
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
                    <p class="center-align">Registrar nueva mascota</p>
                    <form class="col s12" action="registrarMacotas.do" method="POST">

                        <div class="input-field">
                            <input id="nombre" type="text" name="nombre">
                            <label for="nombre">Nombre</label>
                        </div>

                        <div class="input-field">
                            <select name="cboEspecie" id="especie">
                                <option value="" disabled selected>Seleccione la especie</option>
                                <option value="1">Perro</option>
                                <option value="2">Gato</option>
                                <option value="3">Ave</option>
                                <option value="4">Hamster</option>
                            </select>
                            <label for="especie">Especie</label>
                        </div>

                        <div class="input-field">
                            <input id="raza" type="text" name="raza">
                            <label for="txtRaza">Raza</label>
                        </div>
                        <div class="input-field">
                            <input id="edad" type="number" name="edad" class="validate" min="0" max=50 
                                   value="0">
                            <label for="edad">Edad</label>
                        </div>

                        <div class="input-field">
                            <select name="cboSexo" id="sexo" >
                                <option value="" disabled selected>Seleccione el Sexo</option>
                                <option value="1">Hembra</option>
                                <option value="2">Macho</option>
                            </select>
                            <label for="sexo">Sexo</label>
                        </div>
                        <div class="input-field">
                            <input id="fNac" type="date" name="fechaNac"
                                   value=""
                                   min="2000/01/01" max="18/07/2020">
                            <label for="fNac">Fecha de Nacimiento</label>
                        </div>
                        <button  name="bt" value="1" type="submit" class="btn right" >
                            Ingresar
                        </button>
                        <br><br>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col s8 offset-s2 card-panel z-depth-5">
                    <form action="listarMascota.do" method="post">
                        <table class="bordered highlight">
                            <tr>
                                <th>Nombre</th>
                                <th>Especie</th>
                                <th>Raza</th>
                                <th>Edad</th>
                                <th>Sexo</th>
                                <th>Fecha Nac</th>
                            </tr>
                            <c:forEach items="${consul.mascotas}" var="mas"> 
                                <tr>
                                    <td>${mas.nombre}</td>
                                    <td>${mas.especie}</td>
                                    <td>${mas.raza}</td>
                                    <td>${mas.edad}</td>
                                    <td>${mas.sexo}</td>
                                    <td>${mas.fNac}</td>
                                    <td>
                                        <a href="actualizarMascota.jsp?nombre=${mas.nombre}&especie=${mas.especie}&raza=${mas.raza}&edad=${mas.edad}&sexo=${mas.sexo}$sexo=${mas.fNac}" class="btn-floating blue">
                                            <i class="material-icons">mode_edit</i>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="eliminarMascota.jsp?nombre=${mas.nombre}&especie=${mas.especie}&raza=${mas.raza}&edad=${mas.edad}&sexo=${mas.sexo}$sexo=${mas.fNac}" class="btn-floating red">
                                            <i class="material-icons">delete</i>
                                        </a>
                                    </td>
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
        <script>
            $(document).ready(function () {
                $('input#input_text, textarea#textarea1').characterCounter();
            });
        </script>
    </body>
</html>
