<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:set var="nombreDesconocido" value="desconocido"/>  
<c:set var="nombreComparar" value="Pedro"/>     

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Nombre</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${param.nombre == nombreComparar}">
        <h1>¡Hombre <c:out value="${param.nombre}"/>, cuánto tiempo sin verte!</h1>
        </c:when>
        <c:otherwise>
        <h1>Hola <c:out value="${param.nombre}" default="${nombreDesconocido}"/></h1>
        </c:otherwise>
    </c:choose>
		
    <c:if test="${param.nombre == null || empty param.nombre}">
        <div>
            <form method="get" action="formNombreJSTL.jsp">
                <label for="nombre" style="margin-right: 1rem;">Pon aquí tu nombre</label>
                <input id="nombre" name="nombre" type="text" maxlength="50" 
                       placeholder="introduce tu nombre" required="true"/>
                <input type="submit">
            </form>
        </div>
    </c:if>
    </body>
</html>
