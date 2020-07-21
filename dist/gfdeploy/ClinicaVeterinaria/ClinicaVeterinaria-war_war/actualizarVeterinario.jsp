<%-- 
    Document   : actualizarVeterinario
    Created on : 20-07-2020, 18:58:44
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
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <jsp:include page="nav.jsp" />  
                </div>
            </div>
            <div class="row">
                <div class="col s8 offset-s2 card-panel z-depth-5">
                    <p class="center-align">Actualizar Medico Veterinario</p>
                    <form class="col s12" action="actualizarVeterinario.do" method="post">
                        <div class="input-field col s12">
                            <input id="nombre" type="text" name="nombre">
                            <label for="txtNombre">Nombre</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="Apellido" type="text" name="apellido">
                            <label for="txtApellido">Apellido</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="edad" type="number" name="edad">
                            <label for="txtEdad">Edad</label>
                        </div>
                        <div class="input-field col s12">
                            <select>
                                <option value="" disabled selected>Seleccione genero</option>
                                <option value="1">Femenino</option>
                                <option value="2">Masculino</option>
                            </select>
                            <label>Genero</label>
                        </div>
                        <div class="input-field col s12">
                            <select>
                                <option value="" disabled selected>Seleccione la ciudad</option>
                                <option value="1">Arica</option>
                                <option value="2">Iquique</option>
                                <option value="3">Antofagasta</option>
                                <option value="4">Copiapo</option>
                                <option value="5">Coquimbo</option>
                                <option value="6">Viña del Mar</option>
                                <option value="7">Santiago</option>
                                <option value="8">Rancagua</option>
                                <option value="9">Curico</option>
                                <option value="10">Chillan</option>
                                <option value="11">Temuco</option>
                                <option value="12">Valdivia</option>
                                <option value="13">Osorno</option>
                                <option value="14">Puerto Montt</option>
                            </select>
                            <label>Comuna</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="tel" type="number" name="telefono">
                            <label for="txtTel">Telefono</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="cel" type="number" name="celular">
                            <label for="txtCel">Celular</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="dir" type="text" name="direccion">
                            <label for="txtDireccion">Dirección</label>
                        </div>
                        <div class="input-field col s12">
                            <select>
                                <option value="" disabled selected>Seleccione Especialidad</option>
                                <option value="1">Cardiología</option>
                                <option value="2">Fisioterapia</option>
                                <option value="3">Ortopedia</option>
                                <option value="4">Dermatología</option>
                                <option value="5">Neurología</option>
                                <option value="6">Oncología</option>
                            </select>
                            <label>Especialidad</label>
                        </div>

                        <button class="btn waves-effect waves-light" type="submit" name="action">
                            Modificar
                            <i class="material-icons center"></i>
                        </button>
                        <br><br>
                        <br><br>

                    </form>

                </div>
            </div>
    </body>
</html>

