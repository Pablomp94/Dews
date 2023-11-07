<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<style>
.labelPersona {
    display: block;
    clear: right;
    font-weight: 600;
}
</style>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Persona</title>
    </head>
    <body>
        <h1>Formulario de alta - Datos recogidos</h1>
        <div>
            <c:if test="${!empty param.nombre}">
            <span class="labelPersona">Nombre</span>
            <c:out value="${param.nombre}" />
            <br /><br />
            </c:if>
            <c:if test="${!empty param.apellidos}">
            <span class="labelPersona">Apellidos</span>
            <c:out value="${param.apellidos}" />
            <br /><br />
            </c:if>
            <c:if test="${!empty param.dni}">
            <span class="labelPersona">DNI</span>
            <c:out value="${param.dni}" />
            <br /><br />
            </c:if>
            <c:if test="${!empty param.direccion}">
            <span class="labelPersona">Dirección</span>
            <c:out value="${param.direccion}" />
            <br /><br />
            </c:if>
            <c:if test="${!empty param.codpostal}">
            <span class="labelPersona">Código Postal</span>
            <c:out value="${param.codpostal}" />
            <br /><br />
            </c:if>
            <c:if test="${!empty param.localidad}">
            <span class="labelPersona">Localidad</span>
            <c:out value="${param.localidad}" />
            <br /><br />
            </c:if>
            <c:if test="${!empty param.municipio}">
            <span class="labelPersona">Municipio</span>
            <c:out value="${param.municipio}" />
            <br /><br />
            </c:if>
            <c:if test="${!empty param.provincia}">
            <span class="labelPersona">Provincia</span>
            <c:out value="${param.provincia}" />
            <br /><br />
            </c:if>
            <c:if test="${!empty param.sexo}">
            <span class="labelPersona">Sexo</span>
            <c:choose>
                <c:when test="${param.sexo eq 'masculino'}">Masculino</c:when>
                <c:when test="${param.sexo eq 'femenino'}">Femenino</c:when>
                <c:when test="${param.sexo eq 'otro'}">Prefiero no decirlo</c:when>
                <c:otherwise>-</c:otherwise>
            </c:choose>
            <br /><br />
            </c:if>
            <c:if test="${!empty param.nacimiento}">
            <span class="labelPersona">Fecha de nacimiento</span>
            <c:catch>
            <fmt:parseDate value="${param.nacimiento}" pattern="yyyy-MM-dd" var="fNacimiento"/>
            <fmt:formatDate value="${fNacimiento}" var="fechaNac" pattern="dd-MM-yyyy"/>
            <c:out value="${fechaNac}"/>
            </c:catch>
            <br /><br />
            </c:if>
            <c:if test="${!empty paramValues.aficiones}">
            <span class="labelPersona">Aficiones</span>
            <c:forEach items="${paramValues.aficiones}" var="afic">
              <c:out value="${afic}"/><br/>
            </c:forEach>
            </c:if>
        </div>
    </body>
</html>