<%-- 
    Document   : saludo
    Created on : 25 sept 2023, 11:19:33
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String nombreUsuario = "José Alberto"; %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludo</title>
    </head>
    <body>
        <h1>Hola <%= nombreUsuario %></h1>
    </body>
</html>
