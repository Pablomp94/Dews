<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carro de compra</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilos.css"/> 
    </head>
    <body>
        <div><h1>Carrito de la compra</h1></div>
        <div class="menuSup"><a href="inicio">Ir al inicio</a>&nbsp;&nbsp;<a href="verCarrito">Ver carro de compra</a></div>
        <div class="flex-productos">
            <%-- Comprobamos si el carrito tiene productos --%>
            <c:if test="${empty carrito.idProductos}">
                No hay productos en el carrito.
            </c:if>
            <%-- Si el carrito tiene productos --%>
            <c:if test="${!empty carrito.idProductos}">
                <%-- Recorremos la lista de productos del carrito (realmente se recuperan los identificadores de los productos) --%>
                <c:forEach var="idProducto" items="${carrito.idProductos}">
                <%-- recuperamos el producto correspondiente a cada idProducto --%>
                <c:set var="producto" value="${productoServices.getProductoById(idProducto)}"/>
                <div class="productoCarro">
                    <div class="imagenCarro">
                        <a href="producto?idProducto=${idProducto}" title="${producto.titulo}">
                            <img src="${producto.imagenUrl}" alt="foto ${producto.titulo}"/>
                        </a>
                    </div>
                    <div class="contenedorProductoCarro">
                        <div class="titulo">
                            <c:out value="${producto.titulo}"/>
                        </div>
                        <div class="precio">
                            <fmt:formatNumber minIntegerDigits="2" type="currency" currencySymbol="€">${producto.precio}</fmt:formatNumber>
                        </div>
                    </div>
                    <div class="contenedorCantidadCarro">
                        <div class="cantidadProducto">
                            <%-- Cambiamos el valor del parámetro accion para indicar qué se quiere hacer en cada caso con el idProducto --%>
                            <a href="carro?accion=substraer&idProducto=${idProducto}">[-]</a>
                            <span class="cantidadProducto">${carrito.getCantidadProductoById(idProducto)}</span>
                            <a href="carro?accion=anyadir&idProducto=${idProducto}">[+]</a>
                        </div>
                        <div class="borrarProducto">
                            <a href="carro?accion=borrar&idProducto=${idProducto}">Borrar</a>
                        </div>						
                    </div>
                </div>
                </c:forEach>
            </c:if>                
        </div>    
    </body>
</html>
