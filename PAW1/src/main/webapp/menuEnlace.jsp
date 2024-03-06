<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<%! 
public class Enlace {
    private String name;
    private String href;

    public Enlace(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
%>
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
    List<Enlace> lstEnlaces = new ArrayList();
    
    lstEnlaces.add(new Enlace("Inicio", "inicio"));
    lstEnlaces.add(new Enlace("Productos", "productos"));
    lstEnlaces.add(new Enlace("Servicios", "servicios"));
    lstEnlaces.add(new Enlace("Contacto", "contacto"));

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú con Enlaces</title>
    </head>
    <header>
        <nav>
            <ul class="menu">
            <% for(Enlace enlace : lstEnlaces) {%>
                <li class="itemMenu">
                    <a href="<%=enlace.getHref()%>"><%=enlace.getName()%></a>
                </li>
            <%}%>
            </ul>
        </nav>
    </header>
</html>

