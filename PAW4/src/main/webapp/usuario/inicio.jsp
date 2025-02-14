<%-- 
    Document   : menu
    Created on : 3 oct 2023, 14:06:34
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="opcionesMenu">
       value="${[['Inicio', 'inicio.html'],
        ['Productos', 'productos'],
        ['Servicios', 'servicios'],
        ['Contacto', 'contacto'],
       ['Config','config.jsp']]}"/>

<style type="text/css">
.menu {
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: nowrap;
    flex-direction: row;
}
.temaA { background-color: #add8e6; }
.temaV { background-color: #dbff33; }
.temaT { background-color: #33ffbd; }
.itemMenu {
    display: inline-flex;
    padding: 0.5rem 1rem;
}
.itemMenu :hover, .itemMenu :focus {
    color: black;
}
</style>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Config</title>
    </head>
    <header>
        <c:if test="${sessionScope.usuario eq null}">
            <a href="formUsuario.jsp">Registrarse</a>
        </c:if>
        <c:if test="${sessionScope.usuario.nombre != null}">
            Hola <a href="viewUsuario.jsp"><c:out value="${sessionScope.usuario.nombre}"/></a>
        </c:if>
        <nav>
            <ul class="menu ${cookie.configuracionTema.value}">
                <c:forEach var="opcion" items="${opcionesMenu}">
                <li class="itemMenu">
                    <a href="${opcion[1]}">${opcion[0]}</a>
                </li>
                </c:forEach>
            </ul>
        </nav>
    </header>
    <body>
    </body>
</html>
