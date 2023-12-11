<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configuración</title>
    </head>
    <body>
        <form method="get" action="../config">
            <label for="configTema">Seleccione un tema:</label>
            <select name="configTema">
                <option value="temaA" <c:if test="${configuracionTema eq 'temaA'}">selected</c:if>>Tema Azul claro</option>
                <option value="temaV" <c:if test="${configuracionTema eq 'temaV'}">selected</c:if>>Tema Verde lima</option>
                <option value="temaT" <c:if test="${configuracionTema eq 'temaT'}">selected</c:if>>Tema Turquesa</option>
            </select>
            <button type="submit">Seleccionar</button>
        </form>
    </body>
</html>
