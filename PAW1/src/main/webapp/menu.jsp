<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
	String[] opcionesMenu = new String[] {"Inicio", "Productos", "Servicios", "Contacto"}; 
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú</title>
    </head>
    <header>
        <nav>
            <ul>
            <% for(String cadena : opcionesMenu) {%>
                <li style="display: inline-block;"><%=cadena%></li>
            <%}%>
            </ul>
        </nav>
    </header>
</html>
