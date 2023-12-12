package es.albares.dwes.paw3.entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Persona {
    
    public enum Sexo {
        M("Masculino"),
        F("Femenino"),
        O("Prefiero no decirlo");

        private String sexo;
               
        private Sexo(String texto) {
            this.sexo = texto;
        }            
        
        public String getSexo() {
            return this.sexo;
        }   
    }
    
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Sexo getSexo() {
        return sexo;
    }
    
    public String getTextoSexo() {
        return sexo.getSexo();
    }    

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public void setSexo(String codigo) {
        this.sexo = Sexo.valueOf(codigo);
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<String> aficiones) {
        this.aficiones = aficiones;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
