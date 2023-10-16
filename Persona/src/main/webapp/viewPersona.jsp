<%-- 
    Document   : viewPersona
    Created on : 15 oct 2023, 20:03:01
    Author     : Pablo
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<%
    // Obtener los parámetros enviados desde el formulario
    String nombre = request.getParameter("nombre");
    String apellidos = request.getParameter("apellidos");
    String dni = request.getParameter("dni");
    String direccion = request.getParameter("direccion");
    String codpostal = request.getParameter("codpostal");
    String localidad = request.getParameter("localidad");
    String municipio = request.getParameter("municipio");
    String provincia = request.getParameter("provincia");
    String sexo = request.getParameter("sexo");
    String nacimiento = request.getParameter("nacimiento");
    String[] aficiones = request.getParameterValues("aficiones");
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Información de Persona</title>
</head>
<body>
    <h1>Información de Persona</h1>
    <div>
        
        <p><strong>Nombre:</strong> <%= nombre %></p>
        <p><strong>Apellidos:</strong> <%= apellidos %></p>
        <p><strong>DNI:</strong> <%= dni %></p>
        <p><strong>Dirección:</strong> <%= direccion %></p>
        <p><strong>Código Postal:</strong> <%= codpostal %></p>
        <p><strong>Localidad:</strong> <%= localidad %></p>
        <p><strong>Municipio:</strong> <%= municipio %></p>
        <p><strong>Provincia:</strong> <%= provincia %></p>
        <p><strong>Sexo:</strong> <%= sexo %></p>
        <p><strong>Fecha de Nacimiento:</strong> <%= nacimiento %></p>
        <p><strong>Aficiones:</strong>
            <% if (aficiones != null) {
                for (String aficion : aficiones) { %>
                    <%= aficion %><br />
                <% }
            } else { %>
                No se han seleccionado aficiones.
            <% } %>
        </p>
    </div>
</body>
</html>