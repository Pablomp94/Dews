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
            <c:out value="${sessionScope.usuario.nombre}"/>
            <br /><br />
            <span class="labelPersona">Apellidos</span>
            <c:out value="${sessionScope.usuario.apellidos}"/>
            <br /><br />
            <span class="labelPersona">DNI</span>
            <c:out value="${sessionScope.usuario.dni}"/>
            <br /><br />
            <c:if test="${!empty sessionScope.usuario.domicilio}">
            <span class="labelPersona">Dirección</span>
            <c:out value="${sessionScope.usuario.domicilio}"/>
            <br /><br />
            </c:if>
            <span class="labelPersona">Código Postal</span>
            <c:out value="${sessionScope.usuario.codigoPostal}"/>
            <br /><br />
            <c:if test="${!empty sessionScope.usuario.localidad}">
            <span class="labelPersona">Localidad</span>
            <c:out value="${sessionScope.usuario.localidad}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty sessionScope.usuario.municipio}">
            <span class="labelPersona">Municipio</span>
            <c:out value="${sessionScope.usuario.municipio}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty sessionScope.usuario.provincia}">
            <span class="labelPersona">Provincia</span>
            <c:out value="${sessionScope.usuario.provincia}"/>
            <br /><br />
            </c:if>
            <span class="labelPersona">Sexo</span>
            <c:out value="${sessionScope.usuario.textoSexo}"/>
            <br /><br />
            <c:if test="${sessionScope.usuario.fechaNacimiento != null}">
            <span class="labelPersona">Fecha de nacimiento</span>
            <fmt:formatDate value="${sessionScope.usuario.fechaNacimiento}" var="fechaNac" pattern="dd-MM-yyyy"/>
            <c:out value="${fechaNac}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty sessionScope.usuario.aficiones}">
            <span class="labelPersona">Aficiones</span>
            <c:forEach items="${sessionScope.usuario.aficiones}" var="afic">
              <c:out value="${afic}"/><br/>
            </c:forEach>
            </c:if>
        </div>
    </body>
</html>