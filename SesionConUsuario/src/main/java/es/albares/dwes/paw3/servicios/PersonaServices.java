package es.albares.dwes.paw3.servicios;

import es.albares.dwes.paw3.entidades.Persona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author usuario
 */
public class PersonaServices {
    
    public Persona creaPersona(String nombre, String apellidos, String dni, 
            String domicilio, String localidad, String municipio, String codigoPostal, String provincia, 
            String sexo, String[] aficiones, String fechaNacimiento) throws Exception {
        
        Persona persona = new Persona();
        
        // realizamos las comprobaciones de los datos que se recuperan
        // primero los obligatorios
        if (nombre != null && !nombre.isBlank()) {
            persona.setNombre(nombre);
        } else {
            throw new Exception("Nombre es obligatorio");
        }
        if (apellidos != null && !apellidos.isBlank()) {
            persona.setApellidos(apellidos);
        } else {
            throw new Exception("Apellidos es obligatorio");
        }
        if (dni != null && !dni.isBlank()) {
            persona.setDni(dni);
        } else {
            throw new Exception("DNI es obligatorio");
        }
        
        if (domicilio != null && !domicilio.isBlank()) {
            persona.setDomicilio(domicilio);
        } 
        
        if (localidad != null && !localidad.isBlank()) {
            persona.setLocalidad(localidad);
        } 
        
        if (municipio != null && !municipio.isBlank()) {
            persona.setMunicipio(municipio);
        } 
        
        // TODO faltaría comprobar la provincia
        if (provincia != null && !provincia.isBlank()) {
            persona.setProvincia(provincia);
        } 

        if (codigoPostal != null && !codigoPostal.isBlank()) {
            // Comprobamos que CP tiene el formato esperado
            if (codigoPostal.matches("[0-9]{5}")) {
                persona.setCodigoPostal(codigoPostal);
            } else {
                throw new Exception("El codigo postal no tiene el formato esperado {NNNNN}");
            }
        } else {
                throw new Exception("El codigo postal es obligatorio");
            }
        
        if (sexo != null && !sexo.isBlank()) {
            Persona.Sexo eSexo = null;
            try {
                eSexo = Persona.Sexo.valueOf(sexo);
            } catch (Exception ex) {
                throw new Exception("El valor de sexo no es correcto." + ex.getMessage());
            }
            if (eSexo != null) {
                persona.setSexo(eSexo);
            } else {
                throw new Exception("El valor de sexo no es correcto.");
            }
        } else {
                throw new Exception("El valor de sexo es obligatorio.");
        }
        
        if (aficiones != null) {
            persona.setAficiones(new ArrayList<>(Arrays.asList(aficiones)));
        }

        if (fechaNacimiento != null && !fechaNacimiento.isBlank()) {
            SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
            try {
                persona.setFechaNacimiento(sdfIn.parse(fechaNacimiento));
            } catch (Exception ex){
                throw new Exception("El valor de la fecha de nacimiento no es correcto. " + ex.getMessage());
            }
        }

        return persona;
    }
    
/*
    
    private String nombre;
    private String apellidos;
    private String dni;    
    private String domicilio;
    private String localidad;
    private String municipio;
    private String codigoPostal;
    private String provincia;
    private Sexo sexo;
    private List<String> aficiones;
    private Date fechaNacimiento;    
    */    
    
}
