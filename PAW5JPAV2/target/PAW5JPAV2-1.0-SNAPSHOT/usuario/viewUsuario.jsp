<%-- 
    Document   : viewUsuario
    Created on : 28 ene 2024, 13:26:51
    Author     : eloy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de Usuario</title>
        <style>
            .labelPersona {
                display: block;
                clear: right;
                font-weight: 600;
            }

            button a{
                color: black;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${usuarioBean.esValido()}">
                <p>Datos de usuario: <strong><c:out value="${usuarioBean.nombre}"/></strong></p>
                <div>
                    <span class="labelPersona">Nombre</span>
                    <c:out value="${usuarioBean.nombre}"/>
                    <br /><br />
                    <span class="labelPersona">Apellidos</span>
                    <c:out value="${usuarioBean.apellidos}"/>
                    <br /><br />
                    <span class="labelPersona">DNI</span>
                    <c:out value="${usuarioBean.dni}"/>
                    <br /><br />
                    <c:set var="direccion" value="${usuarioBean.direcciones[0]}"/>
                    <span class="labelPersona">Dirección</span>
                    <c:out value="${direccion.direccion}"/>
                    <br /><br />
                    <span class="labelPersona">Código Postal</span>
                    <c:out value="${direccion.codigoPostal}"/>
                    <br /><br />
                    <span class="labelPersona">Localidad</span>
                    <c:out value="${direccion.localidad}"/>
                    <br /><br />
                    <span class="labelPersona">Provincia</span>
                    <c:out value="${direccion.provincia.nombre}"/>
                    <br /><br />
                    <span class="labelPersona">Sexo</span>
                    <c:out value="${usuarioBean.sexo.sexo}"/>
                    <br /><br />
                    <span class="labelPersona">Fecha de nacimiento</span>
                    <fmt:formatDate value="${usuarioBean.fechaNacimiento}" var="fechaNac" pattern="dd-MM-yyyy"/>
                    <c:out value="${fechaNac}"/>
                    <br /><br />
                    <span class="labelPersona">Aficiones</span>
                    <c:forEach items="${usuarioBean.aficiones}" var="afic">
                        <c:out value="${afic.nombre}"/><br/>
                    </c:forEach>
                </div><br/>
                <!--Boton para volver a la página de inicio-->
                <button><a href="inicio.jsp">Volver</a></button>
            </c:when>
            <c:otherwise>
                <h1>¡Error, para acceder a tus datos primero debes autenticarte!</h1>
            </c:otherwise>
        </c:choose>
    </body>
</html>
