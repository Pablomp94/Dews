<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<style>

</style>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <header>
        <span class="mensaje ${mensajeBean.estilo}">${mensajeBean.mensaje}</span>
        <br />
        <c:if test="${usuarioBean.esValido()}">
            Hola <c:out value="${usuarioBean.nombre}"/> <a href="infoUsuario">[Mi perfil]</a> <a href="cerrarSesion">[-Cerrar Sesión-]</a>
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
    <body>
    </body>
</html>