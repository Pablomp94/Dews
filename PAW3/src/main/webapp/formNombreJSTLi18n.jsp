<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.idioma}"/>
<fmt:bundle basename="bundle.mensajes"/>

<!-- Set the locale for fmt -->


<fmt:message key="hombre_ex" var="rb_hombre_ex"/>
<fmt:message key="tiemposinverte" var="rb_tiemposinverte"/>
<fmt:message key="hola" var="rb_hola"/>






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
        

        <c:if test="${empty param.nombre || param.nombre == null}">
            <div>
                <form method="get" action="formNombreJSTLi18n.jsp">
                    <label class="id" for="idioma">Idioma</label>
                    <select class="id" id="idioma" name="locale">
                        <option value="es">Español</option>
                        <option value="en">English</option>
                    </select>

                    </br> 

                    <label for="nombre" style="margin-right: 1rem;">Pon aquí tu nombre</label>
                    <input id="nombre" name="nombre" type="text" maxlength="50" 
                           placeholder="introduce tu nombre" />
                    <input type="submit">
                </form>
            </div>
        </c:if>
     
        <c:choose>
            <c:when test="${param.nombre == nombreComparar}">
                <h1> ${rb_hombre_ex} <c:out value="${param.nombre}"/>, ${rb_tiemposinverte}  <h1>
            </c:when>
            <c:otherwise>
                <h1> ${rb_hola} <c:out value="${param.nombre}" default="${nombreDesconocido}"/></h1>
            </c:otherwise>
        </c:choose> 

                
    </body>
</html>

