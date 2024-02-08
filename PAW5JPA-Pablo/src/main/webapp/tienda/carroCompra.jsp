
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    body {
    font-family: verdana;
}

.menuSup {
    margin: 1rem 0 2rem;    
}

.grid-productos {
    display: grid;
    grid-template-columns: repeat(auto-fill,minmax(15rem,1fr));    
    grid-gap: 1.5rem;
    width: 100%;
}

.flex-productos {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
}

.producto {
    align-items: flex-start;
    z-index: 0;
    width: 100%;
}

.productoCarro {
    display: flex;
    justify-content: flex-start;
    flex-direction: row;
}

.producto a, .productoCarro a {
    color: black;
    text-decoration: none;
}

.contenedorProducto {
    display: flex;
    flex-direction: column;
    height: 100%;
    min-width: 9.75rem;
    max-width: 15rem;
    margin: 0px auto;
    padding: 0px 0.5rem 0.5rem;
    -webkit-box-pack: justify;
    justify-content: space-between;
    width: 100%;    
}

.contenedorProductodetalle {
    max-width: 60rem;    
}

.contenedorProductoCarro, .contenedorCantidadCarro {
    padding: 2rem 2rem 0.5rem;   
    font-weight: bolder;    
}

.contenedorCantidadCarro a {
    color: blue;
    text-decoration: blue;
}


.imagen, .imagenProducto {
    -webkit-box-pack: center;
    justify-content: center;
    width: 100%;
    padding: 1rem 0px;
    margin-bottom: 0.25rem;
    position: relative;
    display: block;
    height: fit-content;
}

.imagen img {
    width: 93%;
}

.imagenCarro {
    width: 15%;
    display: block;
}

.imagenCarro img {
    width: 100%;
    display: block;
}

.titulo {
    font-size: 0.875rem;
    line-height: 1.25rem;
    font-weight: 400;
    letter-spacing: normal;
    margin-bottom: 0.5rem;
    max-height: 3.75rem;
    --max-lines: 3;
    display: -webkit-box;
    -webkit-line-clamp: var(--max-lines);
    -webkit-box-orient: vertical;
    overflow: hidden;
}

.tituloProducto h2 {
    font-size: 1.875rem;
    line-height: 2rem;
    font-weight: 600;
}

.precio {
    font-size: 1.25rem;
    line-height: 1.75rem;
    font-weight: 700;
}

.precioProducto {
    font-size: 1.25rem;
    line-height: 2.75rem;
    font-weight: 700;
}

.borrarProducto {
    margin-top: 1rem;
    text-align: center;
    
    
}

.botonCarrito {
    margin-bottom: 1.5rem;
    display: inline-flex;
    position: relative;
    outline: 0px;
    text-align: center;
    -webkit-box-align: center;
    align-items: center;
    vertical-align: middle;
    text-decoration: none;
    color: rgb(255, 255, 255);
    border: 1px solid transparent;
    border-radius: 4px;
    background: rgb(255, 96, 0);
    transition: background 0.3s ease 0s, box-shadow 0.3s ease 0s, border-color 0.3s ease 0s;
    cursor: pointer;
    font-size: 1.0625rem;
    line-height: 1.5rem;
    font-weight: 600;
    letter-spacing: normal;
    padding: 11px 1rem;
    min-height: 3rem;
    width: 100%;
    -webkit-box-pack: center;
    justify-content: center;
}
</style>

<!DOCTYPE html>

<html>
    <head>
        <title>Carro de compra</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- REVISA LA RUTA DE ACCESO A LA HOJA DE ESTILOS -->
        <link rel="stylesheet" href="../css/estilos.css"/> 
    </head>
    <body>
        <div><h1>Carrito de la compra</h1></div>
        <a href="inicio">Ir al inicio</a>&nbsp;&nbsp;<a href="verCarrito">Ver carro de compra</a>
        <div class="flex-productos">
            <div class="productoCarro">
                <div class="imagenCarro">
                    <a href="[detalle_del_producto]" title="producto">
                            <img src="${map.Producto.imagenUrl(idProducto)}" alt="foto producto"/>  
                    </a>
                </div>
                <div class="contenedorProductoCarro">
                    <div class="titulo">
                        <h2> <c:out value="${map.Producto.marca(idProducto)}"/></h2>
                        <h2> <c:out value="${map.Producto.modelo(idProducto)}"/></h2>
                        <h2> <c:out value="${map.Producto.caracteristicas(idProducto)}"/></h2>
                    </div>
                    <div class="precio">"${map.Producto.precio(idProducto)}"</div>
                </div>
                <div class="contenedorCantidadCarro">
                    <div class="cantidadProducto">
                        <a href=CarroProducto.substraeProducto(id)>[-]</a>
                        <span class="cantidadProducto">"${CarroProductos.getCantidadProductoById(id)}"</span>
                        <a href=CarroProducto.nyadeProducto(id)>[+]</a>
                    </div>
                    <div class="borrarProducto">
                        <a href=CarroProducto.borraProducto(id)>Borrar</a>
                    </div>						
                </div>
            </div>						
                </div>
            </div>

        </div>
    </body>
</html>
