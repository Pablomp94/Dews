<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%-- 
 Es aconsejable tener parametrizados los datos que se utilizan como costantes, 
 o al menos bien identificados en el código. */
--%>
<c:set var="nombreConocido" value="Pedro"/>
<c:set var="nombreDesconocido" value="desconocido"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Nombre</title>
    </head>
    <body>
      <%-- Equivalente a un if-else para tratar cuando el parámetro nombre llega con el valor buscado --%>
      <%-- Se puede hacer un if-else en linea usando ?. En el segundo c:out se muestra un ejemplo --%>
      <c:choose>
        <c:when test="${param.nombre eq nombreConocido}">
        <h1>¡Hombre <c:out value="${param.nombre}"/>, cuánto tiempo sin verte!</h1>
        </c:when>
        <c:otherwise>
        <h1>Hola <c:out value="${empty param.nombre ? nombreDesconocido : param.nombre}" default="${nombreDesconocido}}"/></h1>
        </c:otherwise>
      </c:choose>
             
      <%-- si el parámetro "nombre" no llega o llega vacío mantenemos el formulario --%>
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
