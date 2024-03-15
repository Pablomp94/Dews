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
        <form method="GET" action="listaProductos">
            <label for="selCategoria">Categorias:</label>
            <select id="selCategoria" name="categoria">
                <option value=""<c:if test="${param.categoria == ''}">selected</c:if></option>
                <c:forEach items="${listaCategorias}" var="categoria">
                <option value="${categoria.codigo}" <c:if test="${param.categoria == categoria.codigo}">selected</c:if> >${categoria.nombre}</option>
                </c:forEach>
            </select>
                <input type="checkbox" name="stock" value="S" <c:if test="${param.stock == 'S'}">checked</c:if> aria-label="Solo productos en existencias">&nbsp;Stock
            <button type="submit">Filtrar</button>
            <br>                
        </form>
        <div class="grid-productos">
            <c:forEach var="producto" items="${listaProductos}">
            <div class="producto">
                <a href="producto?idProducto=${producto.id}" title="${producto.titulo}">
                    <div class="contenedorProducto">
                        <div class="imagen">
                            <img src="${producto.imagenUrl}" alt="foto ${producto.titulo}"/>
                        </div>
                        
                            <c:if test="${lstDestacados.contains(producto.id)}">
                            <div class="recomendado">&nbsp;<span>RECOMENDADO!!</span></div>
                            </c:if>
                        <div class="titulo">
                            <c:out value="${producto.titulo}"/>
                        </div>
                        
                            <div class="precio"><fmt:formatNumber minIntegerDigits="2" type="currency" currencySymbol="€">${producto.precio}</fmt:formatNumber></div>
                            <div>
                                <c:if test="${producto.numeroExistencias == 0}">Sin Stock</c:if>
                                <c:if test="${producto.numeroExistencias > 0}">${producto.numeroExistencias} Disponibles</c:if>
                            </div>
                    </div>
                </a>
            </div>
            </c:forEach>
        </div>
    </body>
</html>
