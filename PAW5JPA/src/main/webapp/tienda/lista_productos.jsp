<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Productos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilos.css"/> 
    </head>
    <body>
        <div><h1>Listado de productos</h1></div>
        <div class="menuSup"><a href="../inicio">Ir a inicio</a>&nbsp;&nbsp;<a href="verCarrito">Carro de compra</a></div>
        <div class="grid-productos">
            <c:forEach var="producto" items="${listaProductos}">
            <div class="producto">
                <a href="producto?idProducto=${producto.id}" title="${producto.titulo}">
                    <div class="contenedorProducto">
                        <div class="imagen">
                            <img src="${producto.imagenUrl}" alt="foto ${producto.titulo}"/>
                        </div>
                        <div class="titulo">
                            <c:out value="${producto.titulo}"/>
                        </div>
                            <div class="precio"><fmt:formatNumber minIntegerDigits="2" type="currency" currencySymbol="€">${producto.precio}</fmt:formatNumber></div>
                    </div>
                </a>
            </div>
            </c:forEach>
        </div>
    </body>
</html>
