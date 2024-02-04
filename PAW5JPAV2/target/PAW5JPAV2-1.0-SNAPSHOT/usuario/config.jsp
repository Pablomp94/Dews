<%-- 
    Document   : config
    Created on : 28 ene 2024, 13:01:56
    Author     : eloy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configuración del tema</title>
    </head>
    <body>
        <form method="get" action="config">
            <select name="configTema">
                <option value="temaA">Tema Azul claro</option>
                <option value="temaV">Tema Verde lima</option>
                <option value="temaT">Tema Turquesa</option>
            </select>
            <button type="submit">Seleccionar</button>
        </form>
    </body>
</html>
