<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
.labelPersona {
    display: block;
    clear: right;
    font-weight: 600;    
}
</style>

<c:set var="provincias" value='{"Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
        "Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
        "Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
        "Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona","Santa Cruz de Tenerife",
        "Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};'></c:set>

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
             <c:forEach var="label" items="${['Nombre *', 'Apellidos *', 'DNI *', 'Dirección', 'Código Postal *', 'Localidad', 'Municipio', 'Provincia', 'Sexo *', 'Fecha de nacimiento', 'Aficiones']}">
                <label for="${label}" class="labelPersona">${label}</label>
                <label for="${label}" class="labelPersona">${label}</label>
                <c:choose>
                    <c:when test="${label eq 'Sexo *'}">
                        <fieldset style="border: 1px solid grey; width: 22rem;">
                            <legend>${label}</legend>
                            <input id="sexoM" name="sexo" type="radio" value="Masculino" checked/>
                            <label for="sexoM">Masculino</label>
                            <br />
                            <input id="sexoF" name="sexo" type="radio" value="Femenino"/>
                            <label for="sexoF">Femenino</label>
                            <br>
                            <input id="sexoO" name="sexo" type="radio" value="Prefiero no decirlo"/>
                            <label for="sexoO">Prefiero no decirlo</label>
                        </fieldset>
                    </c:when>
                    <c:when test="${label eq 'Provincia'}">
                        <select id="provincia" name="provincia">
                            <c:forEach var="prov" items="${provincias}">
                                <option value="${prov}">${prov}</option>
                            </c:forEach>
                        </select>
                    </c:when>
                    <c:when test="${label eq 'Aficiones'}">
                        <select id="aficiones" name="aficiones" multiple>
                            <c:forEach var="aficion" items="${['Deporte', 'Música', 'Cine', 'Literatura', 'Viajar', 'Cacharreo']}">
                                <option value="${aficion}">${aficion}</option>
                            </c:forEach>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <input id="${label}" name="${label.toLowerCase()}" type="text" maxlength="100"
                            <c:if test="${label eq 'Código Postal *'}">required placeholder="XXXXX" pattern="[0-9]{5}"</c:if>
                        />
                    </c:otherwise>
                </c:choose>
                <br /><br />
            </c:forEach>
            <label for="confirmacion-PD"><input id="confirmacion-PD" name="protecdatos" type="checkbox" required/>* Los datos de carácter personal que se pudieran recabar directamente de la persona interesada serán tratados de forma confidencial y quedarán incorporados a la correspondiente actividad de tratamiento titularidad de la ...</label>
            <br /><br />
            <input type="submit">
        </form>
    </div>
</body>
</html>
