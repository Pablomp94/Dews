<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="opcionesMenu" value="${[['Inicio', 'inicio.html'],['Productos', 'productos'],['Servicios', 'servicios'],['Contacto', 'contacto'],['Config','config.jsp']]}" /> 

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
        <title>Inicio</title>
    </head>
    <header>
        <c:if test="${! empty usuario.nombre}">
            Hola <a href="viewUsuario.jsp"><c:out value="${usuario.nombre}"/></a>
        </c:if>
        <c:if test="${empty usuario.nombre}">
            <a href="formUsuario.jsp">Registrarse</a>
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
