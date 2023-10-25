<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="org.owasp.encoder.Encode"%>

<style>
.labelPersona {
    display: block;
    clear: right;
    font-weight: 600;
}
</style>
<%
    String nombre = request.getParameter("nombre");
    String apellidos = request.getParameter("apellidos");
    String dni = request.getParameter("dni");
    String direccion = request.getParameter("direccion");
    String codpostal = request.getParameter("codpostal");
    String localidad = request.getParameter("localidad");
    String municipio = request.getParameter("municipio");
    String provincia = request.getParameter("provincia");
    String sexo = request.getParameter("sexo");
    String textoSexo = null;
    switch (sexo) {
        case "masculino" : 
            textoSexo = "Masculino";
            break;
        case "femenino" : 
            textoSexo = "Femenino";
            break;
        case "otro" : 
            textoSexo = "Prefiero no decirlo";
            break;
    }
    
    String nacimiento = request.getParameter("nacimiento");
    String fechaNacimiento = null;
    if (nacimiento != null && !nacimiento.isBlank()) {
        SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
        Date datNacimiento = null;
        try {
            datNacimiento = sdfIn.parse(nacimiento);
        } catch (Exception ex){}
        if (datNacimiento != null) {
            SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy");
            try {
                fechaNacimiento = sdfOut.format(datNacimiento);
            } catch (Exception ex) {}
        }
    }

    String[] aficiones = request.getParameterValues("aficiones");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Persona</title>
    </head>
    <body>
        <h1>Formulario de alta - Datos recogidos</h1>
        <div>
            <%if (nombre != null && !nombre.isBlank()) {%>
            <span class="labelPersona">Nombre</span>
            <%=Encode.forHtml(nombre)%>
            <br /><br />
            <%}%>
            <%if (apellidos != null && !apellidos.isBlank()) {%>
            <span class="labelPersona">Apellidos</span>
            <%=Encode.forHtml(apellidos)%>
            <br /><br />
            <%}%>
            <%if (dni != null && !dni.isBlank()) {%>
            <span class="labelPersona">DNI</span>
            <%=Encode.forHtml(dni)%>
            <br /><br />
            <%}%>
            <%if (direccion != null && !direccion.isBlank()) {%>
            <span class="labelPersona">Dirección</span>
            <%=Encode.forHtml(direccion)%>
            <br /><br />
            <%}%>
            <%if (codpostal != null && !codpostal.isBlank()) {%>
            <span class="labelPersona">Código Postal</span>
            <%=Encode.forHtml(codpostal)%>
            <br /><br />
            <%}%>
            <%if (localidad != null && !localidad.isBlank()) {%>
            <span class="labelPersona">Localidad</span>
            <%=Encode.forHtml(localidad)%>
            <br /><br />
            <%}%>
            <%if (municipio != null && !municipio.isBlank()) {%>
            <span class="labelPersona">Municipio</span>
            <%=Encode.forHtml(municipio)%>
            <br /><br />
            <%}%>
            <%if (provincia != null && !provincia.isBlank()) {%>
            <span class="labelPersona">Provincia</span>
            <%=Encode.forHtml(provincia)%>
            <br /><br />
            <%}%>
            <%if (textoSexo != null && !textoSexo.isBlank()) {%>
            <span class="labelPersona">Sexo</span>
            <%=Encode.forHtml(textoSexo)%>
            <br /><br />
            <%}%>
            <%if (fechaNacimiento != null && !fechaNacimiento.isBlank()) {%>
            <span class="labelPersona">Fecha de nacimiento</span>
            <%=fechaNacimiento%>
            <br /><br />
            <%}%>
            <%if (aficiones != null && aficiones.length > 0) {%>
            <span class="labelPersona">Aficiones</span>
                <%for (String afic : aficiones) {%>
                <%=Encode.forHtml(afic)%><br />
                <%}%>
            <%}%>
        </div>
    </body>
</html>