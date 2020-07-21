<%-- 
    Document   : enfermedad
    Created on : 13-07-2020, 0:25:42
    Author     : Viviana Campos
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="cl.inacap.bean.ContadorConsultasLocal"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! ContadorConsultasLocal contadorConsultas;%>
<% 
    InitialContext c = new InitialContext();
    contadorConsultas = (ContadorConsultasLocal) c.lookup("java:global/ClinicaVeterinaria/ClinicaVeterinaria-ejb/ContadorConsultas!cl.inacap.bean.ContadorConsultasLocal");
%>
<c:set var="consul" value="<%= contadorConsultas %>" scope="page" />

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
                    <p class="center-align">Registrar nueva enfermedad</p>
                    <form class="col s12" action="registrarEnfermedad.do" method="post">
                        <div class="input-field col s12">
                            <input id="enf" type="text" name="enfermedad">
                            <label for="txtEnf">Enfermedad</label>
                        </div>
                        <div class="row col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <textarea name="descripcion" id="desc" class="materialize-textarea" data-length="100"></textarea>
                                    <label for="desc">Descripción</label>
                                </div>
                            </div>
                        </div>
                        <div class="input-field col s12">
                            <input id="prev" type="text" name="prevalencia">
                            <label for="txtPrev">Prevalencia</label>
                        </div> 
                        <div class="row col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <textarea name="tratamiento" id="tto" class="materialize-textarea" data-length="200"></textarea>
                                    <label for="tto">Tratamiento</label>
                                </div>
                            </div>
                        </div>
                        <button name="bt" value="1" type="submit" class="btn center-block" >
                            Registrar
                        </button>
                        <br><br>
                        <br><br>
                    </form>
                </div>
            </div>
        </div>
         <div class="row">
                <div class="col s8 offset-s2 card-panel z-depth-5">
                    <form action="listarEnfermedad.do" method="post">
                        <table class="bordered highlight">
                            <tr>
                                <th>Enfermedad</th>
                                <th>Descripcion</th>
                                <th>Prevalancia</th>
                                <th>Tratamiento</th>
                            </tr>
                            <c:forEach items="${consul.enfermedades}" var="enf"> 
                                <tr>
                                    <td>${enf.nombreEnf}</td>
                                    <td>${enf.descripcion}</td>
                                    <td>${enf.prevalencia}</td>
                                    <td>${enf.tto}</td>
                                    <td>
                                        <a href="actualizarEnfermedad.jsp?enfermedad=${enf.nombreEnf}&descripcion=${enf.descripcion}&prevalencia=${enf.prevalencia}&tratamiento=${enf.tto}" class="btn-floating blue">
                                            <i class="material-icons">mode_edit</i>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="eliminarEnfermedad.jsp?enfermedad=${enf.nombreEnf}&descripcion=${enf.descripcion}&prevalencia=${enf.prevalencia}&tratamiento=${enf.tto}" class="btn-floating red">
                                            <i class="material-icons">delete</i>
                                        </a>
                                    </td>
                                </tr>    
                            </c:forEach>
                                 
                                
                        </table>
                    </form>
                </div>
            </div>   
            
            
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
