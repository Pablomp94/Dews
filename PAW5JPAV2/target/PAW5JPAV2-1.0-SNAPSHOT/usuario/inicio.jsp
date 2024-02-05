<%-- 
    Document   : inicio.jsp
    Created on : 28 ene 2024, 12:50:29
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <style type="text/css">
            .menu {
                display: flex;
                justify-content: space-around;
                align-items: center;
                flex-wrap: nowrap;
                flex-direction: row;
            }

            .itemMenu {
                display: inline-flex;
                padding: 0.5rem 1rem;
            }

            .itemMenu :hover, .itemMenu :focus {
                color: black;
            }

            .temaA {
                background-color: #add8e6;
            }
            .temaV {
                background-color: #dbff33;
            }
            .temaT {
                background-color: #33ffbd;
            }
        </style>
    </head>
    <body>
        <c:set value="${[
                        ['Inicio','inicio'],
                        ['Productos','productos'],
                        ['Servicios','servicios'],
                        ['Config','config.jsp']
                        ]}" var="opcionesMenu"/>
        <header>
            <span class="mensaje ${mensajeBean.estilo}">${mensajeBean.mensaje}</span>
            <br />
            <c:if test="${usuarioBean.esValido()}">
                Hola <c:out value="${usuarioBean.nombre}"/> <a href="infoUsuario">[Mi perfil]</a> <a
                    href="cerrarSesion">[-Cerrar Sesión-]</a>
            </c:if>
            <c:if test="${!usuarioBean.esValido()}">
                <a href="login">Acceder</a> o <a href="formUsuario.jsp">Registrarse</a>
            </c:if>
            <nav>
                <ul class="menu ${cookie.configuracionTema.value}">
                    <c:forEach var="menu" items="${opcionesMenu}">
                        <li class="itemMenu">
                            <a href="${menu[1]}">${menu[0]}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </header>
    </body>
</html>

