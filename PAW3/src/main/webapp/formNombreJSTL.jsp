<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

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
        <h1>Hola <%=nombre%></h1>
        <%--
        <h1>Hola <jsp:expression>nombre</jsp:expression></h1>
        <h1>Hola <%out.print(nombre);%></h1> 
        --%>
		
        <%if (!existeParamNombre) {%>
        <div>
            <form method="get" action="formNombreJSTL.jsp">
                <label for="nombre" style="margin-right: 1rem;">Pon aquí tu nombre</label>
                <input id="nombre" name="nombre" type="text" maxlength="50" 
                       placeholder="introduce tu nombre" required="true"/>
                <input type="submit">
            </form>
        </div>
        <%}%>

        <%--
        <%if (nombre.equalsIgnoreCase("Paco")){%>
            <h1>Cuanto tiempo <%=nombre%></h1>
        <%}%>
        --%>
       

        <c:choose>
            <c:when test="${param.nombre =="Pedro"}"/>
                <h1>¡Hombre, <%=nombre%>, cuánto tiempo sin verte!</h1>
            </c:when>
            <c:otherwise>
                <h1>Hola <c:out value="${param.nombre}" defalult="desconocido"/></h1>
            </c:otherwise>
        </c:choose>    

    </body>
</html>
