<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<style>
    .labelLogin {
        font-weight: 600;
        display: inline-block;
        width: 5rem;
    }
</style>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
            <label class="labelLogin" for="login">Login:</label>
            <input id="login" type="text" name="login"/>
            <br/> <br/>
            <label class="labelLogin" for="password">Password:</label>
            <input id="password" type="password" name="password"/>
            <input type="submit" value="submit" value="Autenticar">
        </form>
    </body>
</html>
