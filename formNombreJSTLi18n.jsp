<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!-- parametro idioma 
http://localhost:8080/PAW3/formNombreJSTLi18n.jsp?idioma=es|en
-->
<fmt:setLocale value="${param.idioma == null ? 'es' : param.idioma}"/>
<%-- prueba XSS para el parametro idioma 
http://localhost:8080/PAW3/formNombreJSTLi18n.jsp?idioma=%3Cscript%3Ealert(%22XSS%22)%3C/script%3E
--%>
<%-- Uso de bundle en lugar de setBundle
<fmt:bundle basename="bundle.mensajes">
<fmt:message key="hombre_ex" var="res_Hombre_ex" bundle="${rb_mensajes}"/>
<fmt:message key="tiempoSinVerte" var="res_tiempoSinVerte" />
<fmt:message key="hola" var="res_Hola"/>
<fmt:message key="desconocido" var="res_desconocido"/>
<fmt:message key="pon_nombre" var="res_pon_nombre"/>
<fmt:message key="introduce_nombre" var="res_tu_nombre"/>
</fmt:bundle>
--%>

<%-- 
 Es aconsejable tener parametrizados los datos que se utilizan como costantes, 
 o al menos bien identificados en el código. */
--%>
<c:set var="nombreConocido" value="Pedro"/>

<fmt:setBundle basename="bundle.mensajes" var="rb_mensajes"/>
<fmt:message key="hombre_ex" var="res_Hombre_ex" bundle="${rb_mensajes}"/>
<fmt:message key="tiempoSinVerte" var="res_tiempoSinVerte" bundle="${rb_mensajes}"/>
<fmt:message key="hola" var="res_Hola" bundle="${rb_mensajes}"/>
<fmt:message key="desconocido" var="res_desconocido" bundle="${rb_mensajes}"/>
<fmt:message key="pon_nombre" var="res_pon_nombre" bundle="${rb_mensajes}"/>
<fmt:message key="introduce_nombre" var="res_tu_nombre" bundle="${rb_mensajes}"/>
<fmt:message key="idioma" var="res_idioma" bundle="${rb_mensajes}"/>
<fmt:message key="espanol" var="res_espanol" bundle="${rb_mensajes}"/>
<fmt:message key="ingles" var="res_ingles" bundle="${rb_mensajes}"/>
<fmt:message key="enviar" var="res_enviar" bundle="${rb_mensajes}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Nombre</title>
    </head>
    <script>
		// Utilizado para recargar la página cuando cambiamos el idioma. No se ha valorado en la práctica, es una mejora.
        function cargaIdioma(select) {
            self.location = "formNombreJSTLi18n.jsp?idioma=" + select.options[select.selectedIndex].value;
        }
    </script>
    <body>
      <c:choose>
        <c:when test="${param.nombre eq nombreConocido}">
            <h1>${res_Hombre_ex} <c:out value="${param.nombre}"/>, ${res_tiempoSinVerte}</h1>
        </c:when>
        <c:otherwise>
        <h1>${res_Hola} <c:out value="${empty param.nombre ? res_desconocido : param.nombre}" default="${res_desconocido}"/></h1>
        </c:otherwise>
      </c:choose>
        
      <c:if test="${param.nombre == null || empty param.nombre}">
        <div>
            <form method="get" action="formNombreJSTLi18n.jsp">
                <label for="idioma" style="margin-right: 1rem;">${res_idioma}</label>
                <select id="idioma" name="idioma" onchange="cargaIdioma(this)">
                    <option value="es" <c:if test="${param.idioma eq 'es'}">selected</c:if>>es-${res_espanol}</option>
                    <option value="en" <c:if test="${param.idioma eq 'en'}">selected</c:if>>en-${res_ingles}</option>
                </select>
                <br />
                <label for="nombre" style="margin-right: 1rem;">${res_pon_nombre}</label>
                <input id="nombre" name="nombre" type="text" maxlength="50" 
                       placeholder="${res_tu_nombre}" />
                <input type="submit" value="${res_enviar}">
            </form>
        </div>
      </c:if>
    </body>
</html>

