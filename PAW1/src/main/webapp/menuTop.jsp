<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="es.albares.dwes.paw1.EnlaceHTML"%>
<%@page import="es.albares.dwes.paw1.MenuServices"%>

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
    MenuServices menuServ = new MenuServices();
    List<EnlaceHTML> lstEnlaces = menuServ.getMenu();    
%>

<nav>
    <ul class="menu">
    <% for(EnlaceHTML enlace : lstEnlaces) {%>
        <li class="itemMenu">
            <a href="<%=enlace.getHref()%>"><%=enlace.getName()%></a>
        </li>
    <%}%>
    </ul>
</nav>

