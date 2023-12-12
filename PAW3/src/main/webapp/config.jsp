<%-- 
    Document   : configTema
    Created on : 10 nov 2023, 13:48:22
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configuración Tema</title>
    </head>
    <body>
        <form method="get" action="${pageContext.request.contextPath}/configUsuario">
            <select name="configTema">
                <option value="temaA">Tema Azul claro</option>
                <option value="temaV">Tema Verde lima</option>
                <option value="temaT">Tema Turquesa</option>
            </select>
            <button type="submit">Seleccionar</button>
        </form>
    </body>
</html>
