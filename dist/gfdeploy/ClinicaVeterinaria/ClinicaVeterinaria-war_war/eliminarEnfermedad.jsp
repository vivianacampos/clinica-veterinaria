<%-- 
    Document   : eliminarEnfermedad
    Created on : 20-07-2020, 17:58:02
    Author     : Artsk
--%>

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
                    <p class="center-align">Eliminar Enfermedad</p>
                    <form class="col s12" action="eliminarEnfermedad.do" method="post">
                        
                        <div class="input-field col s12">
                            <input id="enf" type="text" name="enfermedad" value="${param.nombreEnf}">
                            <label for="txtEnf">Enfermedad</label>
                        </div>
                        <div class="row col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <textarea name="descripcion" id="desc" class="materialize-textarea" data-length="100" value="${param.descripcion}"></textarea>
                                    <label for="desc">Descripción</label>
                                </div>
                            </div>
                        </div>
                        <div class="input-field col s12">
                            <input id="prev" type="text" name="prevalencia" value="${param.prevalencia}">
                            <label for="txtPrev">Prevalencia</label>
                        </div> 
                        <div class="row col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <textarea name="tratamiento" id="tto" class="materialize-textarea" data-length="200" value="${param.tto}"></textarea>
                                    <label for="tto">Tratamiento</label>
                                </div>
                            </div>
                        </div>
                        <button name="bt" value="1" type="submit" class="btn center-block" >
                            Eliminar
                        </button>
                        <br><br>
                        <br><br>
                    </form>
                </div>
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
