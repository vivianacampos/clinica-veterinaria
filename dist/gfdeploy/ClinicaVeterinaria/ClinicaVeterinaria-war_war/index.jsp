<%-- 
    Document   : index
    Created on : 22-06-2020, 16:58:33
    Author     : Viviana Campos
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
        <!-- Contenido-->
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <jsp:include page="nav.jsp" />
                </div>
            </div>
        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(function () {
                $(".button-collapse").sideNav();
            });
        </script>
    </body>
</html>
