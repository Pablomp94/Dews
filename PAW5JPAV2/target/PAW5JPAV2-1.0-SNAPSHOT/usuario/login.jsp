<%-- 
    Document   : login
    Created on : 23 ene 2024, 13:31:41
    Author     : eloy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .labelLogin {
                font-weight: 600;
                display: inline-block;
                width: 5rem;
            }
        </style>
    </head>
    <body>
        <form action="login" method="post">
            <label class="labelLogin" for="login">Login:</label>
            <input id="login" type="text" name="login"/>
            <br/> <br/>
            <label class="labelLogin" for="password">Password:</label>
            <input id="password" type="password" name="password"/>
            <input type="submit" value="Autenticar">
        </form>
    </body>
</html>

