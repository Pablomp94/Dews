<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="org.owasp.encoder.Encode" %>



<c:set var="nombre" value="${param.nombre}" />
<c:set var="apellidos" value="${param.apellidos}" />
<c:set var="dni" value="${param.dni}" />
<c:set var="direccion" value="${param.direccion}" />
<c:set var="codpostal" value="${param.codpostal}" />
<c:set var="localidad" value="${param.localidad}" />
<c:set var="municipio" value="${param.municipio}" />
<c:set var="provincia" value="${param.provincia}" />

<c:set var="sexo" value="${param.sexo}" />
<c:set var="textoSexo" value=""/>
<c:choose>
    <c:when test="${sexo eq 'masculino'}">
        <c:set var="textoSexo" value="Masculino" />
    </c:when>
    <c:when test="${sexo eq 'femenino'}">
        <c:set var="textoSexo" value="Femenino" />
    </c:when>
    <c:when test="${sexo eq 'otro'}">
        <c:set var="textoSexo" value="Prefiero no decirlo" />
    </c:when>
</c:choose>

<c:set var="nacimiento" value="${param.nacimiento}" />
<c:set var="fechaNacimiento" value="" />
<c:if test="${not empty nacimiento}">
    <fmt:parseDate value="${nacimiento}" var="fechaNacimiento" pattern="yyyy-MM-dd" />
</c:if>

<c:set var="formattedFechaNacimiento" value="" />
<c:if test="${not empty fechaNacimiento}">
    <fmt:formatDate value="${fechaNacimiento}" var="formattedFechaNacimiento" pattern="dd-MM-yyyy" />
</c:if>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Persona</title>
    </head>
    <body>
        <h1>Formulario de alta - Datos recogidos</h1>
        <div>
            <c:if test="${not empty param.nombre}">
                <span class="labelPersona">Nombre</span>
                ${Encode.forHtml(param.nombre)}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.apellidos}">
                <span class="labelPersona">Apellidos</span>
                ${Encode.forHtml(param.apellidos)}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.dni}">
                <span class="labelPersona">DNI</span>
                ${Encode.forHtml(param.dni)}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.direccion}">
                <span class="labelPersona">Dirección</span>
                ${Encode.forHtml(param.direccion)}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.codpostal}">
                <span class="labelPersona">Código Postal</span>
                ${Encode.forHtml(param.codpostal)}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.localidad}">
                <span class="labelPersona">Localidad</span>
                ${Encode.forHtml(param.localidad)}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.municipio}">
                <span class="labelPersona">Municipio</span>
                ${Encode.forHtml(param.municipio)}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.provincia}">
                <span class="labelPersona">Provincia</span>
                ${Encode.forHtml(param.provincia)}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.sexo}">
                <span class="labelPersona">Sexo</span>
                <c:choose>
                    <c:when test="${param.sexo eq 'masculino'}">Masculino</c:when>
                    <c:when test="${param.sexo eq 'femenino'}">Femenino</c:when>
                    <c:when test="${param.sexo eq 'otro'}">Prefiero no decirlo</c:when>
                </c:choose>
                <br /><br />
            </c:if>
            <c:if test="${not empty param.nacimiento}">
                <span class="labelPersona">Fecha de nacimiento</span>
                <c:set var="fechaNacimiento" value="" />
                <fmt:parseDate value="${param.nacimiento}" var="fechaNacimiento" pattern="yyyy-MM-dd" />
                <fmt:formatDate value="${fechaNacimiento}" var="fechaNacimiento" pattern="dd-MM-yyyy" />
                ${fechaNacimiento}
                <br /><br />
            </c:if>
            <c:if test="${not empty param.aficiones}">
                <span class="labelPersona">Aficiones</span>
                <c:forEach var="aficion" items="${paramValues.aficiones}">
                    ${Encode.forHtml(aficion)}<br />
                </c:forEach>
            </c:if>
        </div>
    </body>
</html>
