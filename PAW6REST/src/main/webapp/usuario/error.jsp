<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <p>Se ha producido un error:<br />
            <c:out value="${error}"/></p>
        <br />
        <p><a href="inicio.jsp">Página de inicio</a></p>
    </body>
</html>
