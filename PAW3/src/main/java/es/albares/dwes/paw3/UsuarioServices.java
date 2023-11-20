/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw3;

import es.albares.dwes.paw3.entidades.Persona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Pablo
 */
class UsuarioServices {
     public usuario creaUsuario(String nombre, String apellidos, String dni, 
            String domicilio, String localidad, String municipio, String codigoPostal, String provincia, 
            String sexo, String[] aficiones, String fechaNacimiento) throws Exception {
        
        Persona persona = new Persona();
        
        // realizamos las comprobaciones de los datos que se recuperan
        // primero los obligatorios
        if (nombre != null && !nombre.isBlank()) {
            usuario.setNombre(nombre);
        } else {
            throw new Exception("Nombre es obligatorio");
        }
        if (apellidos != null && !apellidos.isBlank()) {
            usuario.setApellidos(apellidos);
        } else {
            throw new Exception("Apellidos es obligatorio");
        }
        if (dni != null && !dni.isBlank()) {
            usuario.setDni(dni);
        } else {
            throw new Exception("DNI es obligatorio");
        }
        
        if (domicilio != null && !domicilio.isBlank()) {
            usuario.setDomicilio(domicilio);
        } 
        
        if (localidad != null && !localidad.isBlank()) {
            usuario.setLocalidad(localidad);
        } 
        
        if (municipio != null && !municipio.isBlank()) {
            usuario.setMunicipio(municipio);
        } 
        
        // TODO faltaría comprobar la provincia
        if (provincia != null && !provincia.isBlank()) {
            usuario.setProvincia(provincia);
        } 

        if (codigoPostal != null && !codigoPostal.isBlank()) {
            // Comprobamos que CP tiene el formato esperado
            if (codigoPostal.matches("[0-9]{5}")) {
                usuario.setCodigoPostal(codigoPostal);
            } else {
                throw new Exception("El codigo postal no tiene el formato esperado {NNNNN}");
            }
        } else {
                throw new Exception("El codigo postal es obligatorio");
            }
        
        if (sexo != null && !sexo.isBlank()) {
            Usuario.Sexo eSexo = null;
            try {
                eSexo = Usuario.Sexo.valueOf(sexo);
            } catch (Exception ex) {
                throw new Exception("El valor de sexo no es correcto." + ex.getMessage());
            }
            if (eSexo != null) {
                usuario.setSexo(eSexo);
            } else {
                throw new Exception("El valor de sexo no es correcto.");
            }
        } else {
                throw new Exception("El valor de sexo es obligatorio.");
        }
        
        if (aficiones != null) {
            usuario.setAficiones(new ArrayList<>(Arrays.asList(aficiones)));
        }

        if (fechaNacimiento != null && !fechaNacimiento.isBlank()) {
            SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
            try {
                persona.setFechaNacimiento(sdfIn.parse(fechaNacimiento));
            } catch (Exception ex){
                throw new Exception("El valor de la fecha de nacimiento no es correcto. " + ex.getMessage());
            }
        }

        return usuario;
    }
    
/*
}
