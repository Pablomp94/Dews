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
            <span class="labelPersona">Nombre</span>
            <c:out value="${persona.nombre}"/>
            <br /><br />
            <span class="labelPersona">Apellidos</span>
            <c:out value="${persona.apellidos}"/>
            <br /><br />
            <span class="labelPersona">DNI</span>
            <c:out value="${persona.dni}"/>
            <br /><br />
            <c:if test="${!empty persona.domicilio}">
            <span class="labelPersona">Dirección</span>
            <c:out value="${persona.domicilio}"/>
            <br /><br />
            </c:if>
            <span class="labelPersona">Código Postal</span>
            <c:out value="${persona.codigoPostal}"/>
            <br /><br />
            <c:if test="${!empty persona.localidad}">
            <span class="labelPersona">Localidad</span>
            <c:out value="${persona.localidad}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty persona.municipio}">
            <span class="labelPersona">Municipio</span>
            <c:out value="${persona.municipio}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty persona.provincia}">
            <span class="labelPersona">Provincia</span>
            <c:out value="${persona.provincia}"/>
            <br /><br />
            </c:if>
            <span class="labelPersona">Sexo</span>
            <c:out value="${persona.textoSexo}"/>
            <br /><br />
            <c:if test="${persona.fechaNacimiento != null}">
            <span class="labelPersona">Fecha de nacimiento</span>
            <fmt:formatDate value="${persona.fechaNacimiento}" var="fechaNac" pattern="dd-MM-yyyy"/>
            <c:out value="${fechaNac}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty persona.aficiones}">
            <span class="labelPersona">Aficiones</span>
            <c:forEach items="${persona.aficiones}" var="afic">
              <c:out value="${afic}"/><br/>
            </c:forEach>
            </c:if>
        </div>
    </body>
</html>