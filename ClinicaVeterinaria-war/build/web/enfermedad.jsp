<%-- 
    Document   : enfermedad
    Created on : 13-07-2020, 0:25:42
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
            <div class="col s12">
                <jsp:include page="nav.jsp" />  
            </div>
            <div class="row">
                <div class="col s8 offset-s2 card-panel z-depth-5">
                    <p class="center-align">Registrar nueva enfermedad</p>
                    <form class="col s12" action="registrar.do" method="post">
                        <div class="input-field col s12">
                            <input id="enf" type="text" name="enfermedad">
                            <label for="txtEnf">Enfermedad</label>
                        </div>
                        <div class="row col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <textarea id="desc" class="materialize-textarea" data-length="100"></textarea>
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
                                    <textarea id="tto" class="materialize-textarea" data-length="200"></textarea>
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
        <script>
            $(document).ready(function () {
                $('input#input_text, textarea#textarea1').characterCounter();
            });

        </script>
    </body>
</html>
