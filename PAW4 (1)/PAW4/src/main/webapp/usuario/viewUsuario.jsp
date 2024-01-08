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
        <title>Usuario</title>
    </head>
    <body>
        <h1>Datos del usuario</h1>
        <c:if test="${! empty usuario}">        
        <div>
            <span class="labelPersona">Nombre</span>
            <c:out value="${usuario.nombre}"/>
            <br /><br />
            <span class="labelPersona">Apellidos</span>
            <c:out value="${usuario.apellidos}"/>
            <br /><br />
            <span class="labelPersona">DNI</span>
            <c:out value="${usuario.dni}"/>
            <br /><br />
            <c:if test="${!empty usuario.domicilio}">
            <span class="labelPersona">Dirección</span>
            <c:out value="${usuario.domicilio}"/>
            <br /><br />
            </c:if>
            <span class="labelPersona">Código Postal</span>
            <c:out value="${usuario.codigoPostal}"/>
            <br /><br />
            <c:if test="${!empty usuario.localidad}">
            <span class="labelPersona">Localidad</span>
            <c:out value="${usuario.localidad}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty usuario.municipio}">
            <span class="labelPersona">Municipio</span>
            <c:out value="${usuario.municipio}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty usuario.provincia}">
            <span class="labelPersona">Provincia</span>
            <c:out value="${usuario.provincia}"/>
            <br /><br />
            </c:if>
            <span class="labelPersona">Sexo</span>
            <c:out value="${usuario.textoSexo}"/>
            <br /><br />
            <c:if test="${usuario.fechaNacimiento != null}">
            <span class="labelPersona">Fecha de nacimiento</span>
            <fmt:formatDate value="${usuario.fechaNacimiento}" var="fechaNac" pattern="dd-MM-yyyy"/>
            <c:out value="${fechaNac}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty usuario.aficiones}">
            <span class="labelPersona">Aficiones</span>
            <c:forEach items="${usuario.aficiones}" var="afic">
              <c:out value="${afic}"/><br/>
            </c:forEach>
            </c:if>
        </div>
        </c:if>
        <c:if test="${usuario == null || empty usuario}">No hay datos del usuario</c:if>
        <p><a href="inicio.jsp">página de inicio</a></p>
    </body>
</html>