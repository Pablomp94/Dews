<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="nombreDesconocido" value="desconocido"/>  
<c:set var="nombreComparar" value="Pedro"/>     

<c:set var="NOMBRE_XDEFECTO" value="desconocido"/> 
<c:set var="nombre" value="${NOMBRE_XDEFECTO}"/> 

<c:choose>
    <c:when test="${not empty param.nombre}">
        <c:set var="nombre" value="${param.nombre}"/>
    </c:when>
</c:choose>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Nombre</title>
    </head>
    <body>
        
       

        <c:if test="${empty param.nombre}">
            <div>
                <form method="get" action="formNombreJSTL.jsp">
                    <label class="id" for="idioma">Idioma</label>
                    <select class="id" id="idioma" name="locale">
                        <option value="es">Español</option>
                        <option value="en">English</option>
                    </select>

                    </br> 

                    <label for="nombre" style="margin-right: 1rem;">Pon aquí tu nombre</label>
                    <input id="nombre" name="nombre" type="text" maxlength="50" 
                           placeholder="introduce tu nombre" required/>
                    <input type="submit">
                </form>
            </div>
        </c:if>

        
        
        
        <!-- Set the locale for fmt -->
        <fmt:setLocale value="${param.locale}" scope="session"/>
     
        <c:choose>
            
            
            <c:when test="${param.nombre == nombreComparar}">
                <h1>¡Hombre <c:out value="${param.nombre}"/>, cuánto tiempo sin verte!</h1>
            </c:when>
            
            <c:when test="${(param.nombre != null && param.nombre != nombreComparar)}">
                <h1>Hola <c:out value="${param.nombre}"/></h1>
            </c:when>
            
           
        </c:choose> 
    </body>
</html>
