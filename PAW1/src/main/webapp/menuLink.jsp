<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    .menu {
        display: flex;
        justify-content: space-around;
        align-items: center;
        flex-wrap: nowrap;
        flex-direction: row;
        background-color: #add8e6;
    }
    
    .itemMenu {
        display: inline-flex;
        padding: 0.5rem 1rem;
    }
    
    .itemMenu :hover, .itemMenu :focus {
        color: black;
    }
</style>
    
<% 
  String[][] opcionesMenu = new String[][] {
	{"Inicio", "inicio"},
	{"Productos", "productos"},
	{"Servicios", "servicios"},
	{"Contacto", "contacto"}}; 
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Link</title>
    </head>
    <header>
        <nav>
            <ul class="menu">
            <% for(String[] enlace : opcionesMenu) {%>
                <li class="itemMenu">
                    <a href="<%=enlace[1]%>"><%=enlace[0]%></a>
                </li>
            <%}%>
            </ul>
        </nav>
    </header>
</html>
