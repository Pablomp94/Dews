<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
.labelPersona {
    display: block;
    clear: right;
    font-weight: 600;    
}
</style>

<%
    String[] provincias = {"Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
        "Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
        "Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
        "Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
        "Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario - Persona</title>
    </head>
    <body>
        <h1>Formulario de alta</h1>
        <div>
            <form method="get" action="viewPersona.jsp">
                <label for="nombre" class="labelPersona">Nombre *</label>
                <input id="nombre" name="nombre" type="text" maxlength="100" size="50" required/>
                <br /><br />
                <label for="apellidos" class="labelPersona">Apellidos *</label>
                <input id="apellidos" name="apellidos" type="text" maxlength="150" size="70" required/>
                <br /><br />
                <label for="dni" class="labelPersona">DNI *</label>
                <input id="dni" name="dni" type="text" maxlength="11" size="20" required/>
                <br /><br />                
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
                <label for="municipio" class="labelPersona">Municipio</label>
                <input id="municipio" name="municipio" type="text" maxlength="50" size="50"/>
                <br /><br />
                <label for="provincia" class="labelPersona">Provincia</label>
                <select id="provincia" name="provincia">
                    <%for (String prov : provincias) {%>
                    <option value="<%=prov%>"><%=prov%></option>
                    <%}%>
                </select>
                <br /><br />
                <fieldset style="border: 1px solid grey; width: 22rem;">
                <legend>Sexo *</legend>
                    <input id="sexoM" name="sexo" type="radio" value="masculino" checked/>
                    <label for="sexoM">Masculino</label>
                    <br />
                    <input id="sexoF" name="sexo" type="radio" value="femenino"/>
                    <label for="sexoF">Femenino</label>
                    <br>
                    <input id="sexoO" name="sexo" type="radio" value="otro"/>
                    <label for="sexoO">Prefiero no decirno</label>
                </fieldset>
                <br /><br />
                <label for="fecha-nac" class="labelPersona">Fecha de nacimiento</label>
                <input id="fecha-nac" name="nacimiento" type="date"/>
                <br /><br />
                <label for="aficiones" class="labelPersona">Aficiones</label>
                <select id="aficiones" name="aficiones" multiple>
                    <option value="deporte">Deporte</option>
                    <option value="musica">Música</option>
                    <option value="cine">Cine</option>
                    <option value="literatura">Literatura</option>
                    <option value="viajar">Viajar</option>
                    <option value="cacharreo">Cacharreo</option>
                </select>
                <br /><br />
                <label for="confirmacion-PD"><input id="confirmacion-PD" name="protecdatos" type="checkbox" required/>* Los datos de carácter personal que se pudieran recabar directamente de la persona interesada serán tratados de forma confidencial y quedarán incorporados a la correspondiente actividad de tratamiento titularidad de la ...</label>
                <br /><br />
                <input type="submit" >
            </form>
        </div>
    </body>
</html>