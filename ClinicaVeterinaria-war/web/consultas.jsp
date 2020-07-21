<%-- 
    Document   : consultas
    Created on : 20-07-2020, 0:05:10
    Author     : Viviana Campos
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="cl.inacap.bean.ContadorConsultasLocal"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! ContadorConsultasLocal contadorConsultas;%>
<% 
    InitialContext c = new InitialContext();
    contadorConsultas = (ContadorConsultasLocal) c.lookup("java:global/ClinicaVeterinaria/ClinicaVeterinaria-ejb/ContadorConsultas!cl.inacap.bean.ContadorConsultasLocal");
%>
<c:set var="consul" value="<%= contadorConsultas %>" scope="page" />

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
                <div class="row">
                    <div class="col s8 offset-s2 card-panel z-depth-5">
                        <p class="center-align">Contador de consultas</p>
                        <div>
                            <p>Las consultas realizadas a la BD son: </p>
                            <label>${consul.contador}</label>
                         </div>
                    </div>

                </div>

                </body>
                </html>
