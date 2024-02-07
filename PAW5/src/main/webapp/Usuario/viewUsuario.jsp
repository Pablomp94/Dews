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
        <c:if test="${usuarioBean.esValido()}">
        <div>
            <span class="labelPersona">Nombre</span>
            <c:out value="${usuarioBean.nombre}"/>
            <br /><br />
            <span class="labelPersona">Apellidos</span>
            <c:out value="${usuarioBean.apellidos}"/>
            <br /><br />
            <span class="labelPersona">DNI</span>
            <c:out value="${usuarioBean.dni}"/>
            <br /><br />
            <c:if test="${!empty usuarioBean.direcciones[0].direccion}">
            <span class="labelPersona">Dirección</span>
            <c:out value="${usuarioBean.direcciones[0].direccion}"/>
            <br /><br />
            </c:if>
            <span class="labelPersona">Código Postal</span>
            <c:out value="${usuarioBean.direcciones[0].codigoPostal}"/>
            <br /><br />
            <c:if test="${!empty usuarioBean.direcciones[0].localidad}">
            <span class="labelPersona">Localidad</span>
            <c:out value="${usuarioBean.direcciones[0].localidad}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty usuarioBean.direcciones[0].provincia}">
            <span class="labelPersona">Provincia</span>
            <c:out value="${usuarioBean.direcciones[0].provincia.nombre}"/>
            <br /><br />
            </c:if>
            <span class="labelPersona">Sexo</span>
            <c:out value="${usuarioBean.sexo.sexo}"/>
            <br /><br />
            <c:if test="${usuarioBean.fechaNacimiento != null}">
            <span class="labelPersona">Fecha de nacimiento</span>
            <fmt:formatDate value="${usuarioBean.fechaNacimiento}" var="fechaNac" pattern="dd-MM-yyyy"/>
            <c:out value="${fechaNac}"/>
            <br /><br />
            </c:if>
            <c:if test="${!empty usuarioBean.aficiones}">
            <span class="labelPersona">Aficiones</span>
            <c:forEach items="${usuarioBean.aficiones}" var="afic">
              <c:out value="${afic.nombre}"/><br/>
            </c:forEach>
            </c:if>
            <br /><br />
            <span class="labelPersona">Login</span>
            <c:out value="${usuarioBean.login}"/>
            <br /><br />
            <span class="labelPersona">E-mail</span>
            <c:out value="${usuarioBean.email}"/>
            <br /><br />            
        </div>
        </c:if>
        <c:if test="${!usuarioBean.esValido()}">No hay datos del usuario</c:if>
        <p><a href="inicio.jsp">página de inicio</a></p>
    </body>
</html>