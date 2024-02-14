<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<style>
.labelPersona {
    display: block;
    clear: right;
    font-weight: 600;    
}
</style>

<script>
function verificarPassw() {
    if (document.getElementById('password').value ===
            document.getElementById('password_rep').value) {
        return true;
    } else {
        alert("Contraseñas no coinciden");
        return false;
    }
}
</script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Persona</title>
    </head>
    <body>
        <h1>Formulario de alta</h1>
        <div>
            <form method="post" action="altaUsuario" onsubmit="return verificarPassw()">
                <label for="nombre" class="labelPersona">Nombre *</label>
                <input id="nombre" name="nombre" type="text" maxlength="100" size="50" required/>
                <br /><br />
                <label for="apellidos" class="labelPersona">Apellidos *</label>
                <input id="apellidos" name="apellidos" type="text" maxlength="150" size="70" required/>
                <br /><br />
                <label for="dni" class="labelPersona">DNI *</label>
                <input id="dni" name="dni" type="text" maxlength="11" size="20" required/>
                <br /><br />   
                <fieldset style="border: 1px solid grey; width: 22rem;">
                <legend>Sexo *</legend>
                    <input id="sexoM" name="sexo" type="radio" value="M" checked/>
                    <label for="sexoM">Masculino</label>
                    <br />
                    <input id="sexoF" name="sexo" type="radio" value="F"/>
                    <label for="sexoF">Femenino</label>
                    <br>
                    <input id="sexoO" name="sexo" type="radio" value="O"/>
                    <label for="sexoO">Prefiero no decirno</label>
                </fieldset>
                <br /><br />
                <label for="fecha-nac" class="labelPersona">Fecha de nacimiento</label>
                <input id="fecha-nac" name="nacimiento" type="date"/>
                <br /><br />
                <fieldset>
                    <legend>Dirección</legend>
                    <label for="direccion" class="labelPersona">Dirección</label>
                    <input id="direccion" name="direccion" type="text" maxlength="250" size="100"/>
                    <br /><br />
                    <label for="codpostal" class="labelPersona">Código Postal *</label>
                    <input id="codpostal" name="codpostal" type="text" maxlength="5" size="5" required
                           placeholder="XXXXX" pattern="[0-9]{5}"/>
                    <br /><br />
                    <label for="localidad" class="labelPersona">Localidad</label>
                    <input id="localidad" name="localidad" type="text" maxlength="100" size="70"/>
                    <br /><br />
                    <label for="provincia" class="labelPersona">Provincia</label>
                    <select id="provincia" name="provincia">
                    <c:forEach var="prov" items="${provinciaRepo.provincias}">
                        <option value="${prov.codigo}"/>${prov.nombre}</option>
                    </c:forEach>
                    </select>
                    <br /><br />
                </fieldset>
                <label for="aficiones" class="labelPersona">Aficiones</label>
                <select id="aficiones" name="aficiones" multiple>
                  <c:forEach var="afic" items="${aficionRepo.aficiones}">
                    <option value="${afic.nombre}">${afic.nombre}</option>
                  </c:forEach>
                </select>
                <br /><br />
                <fieldset>
                    <legend>Autenticación</legend>
                    <label for="login" class="labelPersona">Login</label>
                    <input id="login" name="login" type="text" maxlength="50" size="50"/>
                    <br /><br />
                    <label for="password" class="labelPersona">Password</label>
                    <input id="password" name="password" type="password" maxlength="50" size="50"/>
                    <br /><br />
                    <label for="password_rep" class="labelPersona">Repetir Password</label>
                    <input id="password_rep" name="password_rep" type="password" maxlength="50" size="50"/>
                    <br /><br />
                    <label for="email" class="labelPersona">E-mail</label>
                    <input id="email" name="email" type="text" maxlength="75" size="75"/>
                    <br /><br />
                </fieldset>
                <label for="confirmacion-PD"><input id="confirmacion-PD" name="protecdatos" type="checkbox" required/>Los datos de carácter personal que se pudieran recabar directamente de la persona interesada serán tratados de forma confidencial y quedarán incorporados a la correspondiente actividad de tratamiento titularidad de la ...</label>
                <br /><br />
                <input id="boton_submit" type="submit">
            </form>
        </div>
    </body>
</html>