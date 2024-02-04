<%-- 
    Document   : error
    Created on : 28 ene 2024, 13:39:15
    Author     : eloy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        <h1><c:out value="${error}"/></h1>
    </body>
</html>
