<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>

<html>
    <head>
        <title>${producto.titulo}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilos.css"/> 
    </head>
    <body>
        <h1><c:out value="${producto.titulo}"/></h1>
        <div class="menuSup"><a href="inicio">Ir al inicio</a>&nbsp;&nbsp;<a href="verCarrito">Ver carro de compra</a></div>
        <form action="carro" method="get">
        <div class="producto">
            <div class="contenedorProducto contenedorProductodetalle">
                <span>Fecha lanzamiento: <c:out value="${producto.fechaLanzamiento}"/></span>
                <div class="imagenProducto">
                    <img src="${producto.imagenUrl}" alt="foto ${producto.titulo}"/>
                </div>
                <div class="titulo tituloProducto">
                    <h2><c:out value="${producto.titulo}"/></h2>
                </div>
                <div class="precio"><fmt:formatNumber minIntegerDigits="2" type="currency" currencySymbol="€">${producto.precio}</fmt:formatNumber></div>
                <button type="submit" class="botonCarrito">Añadir al carro</button>
                <input hidden name="idProducto" value="${producto.id}">
                <input hidden name="accion" value="anyadir">
                <!--<input hidden name="[completar_]" value="[completar_]">-->
                <h3>Especificaciones:</h3>
                <!-- Especificaciones -->
                ${producto.especificaciones} 
                <!-- FIN Especificaciones -->
            </div>
        </div>
        </form>
        
    </body>
</html>
