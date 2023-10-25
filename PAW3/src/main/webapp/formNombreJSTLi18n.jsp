<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:set var="nombreDesconocido" value="desconocido"/>  
<c:set var="nombreComparar" value="Pedro"/>     

<%
    String NOMBRE_XDEFECTO = "desconocido"; 
    String nombre = NOMBRE_XDEFECTO;
    
    // true si existe el parametro nombre
    Boolean existeParamNombre = false;
    
    String nombreParam = request.getParameter("nombre");
    if (nombreParam != null && !nombreParam.isBlank()) {
        nombre = nombreParam;
        existeParamNombre = true;        
    }
%>





<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Nombre</title>
    </head>
    <body>

        <c:if test="${param.nombre == null || empty param.nombre}">
            <div>
                <form method="get" action="formNombreJSTL.jsp">
                    <label class="id" for="idioma">Idioma</label>
                    <select class="id" id="idioma" name="Idioma:">
                        <option value="texto.jsp?locale=es">Español</option>
                        <option value="texto.jsp?locale=en">English</option>
                    </select>

                    </br> 

                    <label for="nombre" style="margin-right: 1rem;">Pon aquí tu nombre</label>
                    <input id="nombre" name="nombre" type="text" maxlength="50" 
                           placeholder="introduce tu nombre" required="true"/>
                    <input type="submit">
                </form>
            </div>
        </c:if>

        <c:choose>
            <c:when test="${param.nombre == nombreComparar}">
                <h1>¡Hombre <c:out value="${param.nombre}"/>, cuánto tiempo sin verte!</h1>
                
            </c:when>
            <c:otherwise>
                <c:if test="${param.locale!=null}">
                    <h1><fmt:setLocale value="${hola.locale}"/> <c:out value="${param.nombre}" default="${nombreDesconocido}"/></h1>
                </c:if>
                <!--<h1>Hola <c:out value="${param.nombre}" default="${nombreDesconocido}"/></h1> -->
                        
                <c:if test="${param.locale==en}">
                    <h1><fmt:setLocale value="${hola.en}"/> <c:out value="${param.nombre}" default="${nombreDesconocido}"/></h1>
                </c:if>
            </c:otherwise>
        </c:choose> 
    </body>
</html>
