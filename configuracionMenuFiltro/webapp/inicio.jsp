<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="opcionesMenu" value="${['Inicio','Productos','Servicios','Contacto']}" /> 


<style type="text/css">
.menu {
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: nowrap;
    flex-direction: row;
}

.temaA { background-color: #add8e6; }
.temaV { background-color: #dbff33; }
.temaT { background-color: #33ffbd; }

.itemMenu {
    display: inline-flex;
    padding: 0.5rem 1rem;
}
.itemMenu :hover, .itemMenu :focus {
    color: black;
}
</style>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <header>
        <nav>
            <ul class="menu ${configuracionTema}">
                <c:forEach var="menu" items="${opcionesMenu}">
                <li class="itemMenu">
                    ${menu}
                </li>
                </c:forEach>
                <li class="itemMenu">
                    <a href="config/config.jsp">Config</a>
                </li>                
            </ul>
        </nav>
    </header>
    <body>
    </body>
</html>
