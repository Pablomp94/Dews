<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

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
        <title>Contadores</title>
    </head>
    <body>
        <h1>Contadores</h1>
        <div>
            <form method="get" action="contador">
                Contador de Aplicación: ${contadorApplication}
                <input hidden="true" id="contadorApplic" name="incrementa" value="application">
                <input type="submit" value="Incrementa Application">
            </form>    
            <form method="get" action="contador">
                Contador de Sesión: ${contadorSession}
                <input hidden="true" id="contadorSession" name="incrementa" value="session">                
                <input type="submit" value="Incrementa Session">
            </form>
            <form method="get" action="contador">
                Contador de petición: <c:out value="${contadorRequest}" default="0"/>
                <input hidden="true" id="contadorRequest" name="incrementa" value="request">
                <input type="submit" value="Incrementa Request">
            </form>                
            <form method="get" action="contador">
                <input hidden="true" id="cerrarSesion" name="incrementa" value="cerrar">                
                <input type="submit" value="Cerrar Session">
            </form>
            <form method="get" action="contador">
                <input hidden="true" id="reiniciarTodo" name="incrementa" value="reiniciar">                
                <input type="submit" value="Reiniciar Todo">
            </form>
        </div>
    </body>
</html>