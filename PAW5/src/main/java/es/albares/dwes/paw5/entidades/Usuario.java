/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

/**
 *
 * @author Pablo
 */
public class Usuario implements Serializable {

    private static long serialVersionUID = 1L; // versión de la entidad
    public Integer id;
    private String nombre;
    private String apellidos;
    private Sexo sexo;
    private Date fechaNacimiento;
    private String dni;
    private String login;
    private String password;
    private String email;
    private Date fechaRegistro;

    private Collection<Direccion> direcciones;
    private Collection<Aficion> aficiones;
    private Collection<Rol> roles;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public Usuario(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellidos, String sexo, java.sql.Date fechaNac, String dni, String login, String password, String email, java.sql.Date fechaReg) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = Sexo.valueOf(sexo);
        this.fechaNacimiento = fechaNac;
        this.dni = dni;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fechaRegistro = fechaReg;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = Sexo.valueOf(sexo);
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the direcciones
     */
    public Collection<Direccion> getDirecciones() {
        return direcciones;
    }

    /**
     * @param direcciones the direcciones to set
     */
    public void setDirecciones(Collection<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    /**
     * @return the aficiones
     */
    public Collection<Aficion> getAficiones() {
        return aficiones;
    }

    /**
     * @param aficiones the aficiones to set
     */
    public void setAficiones(Collection<Aficion> aficiones) {
        this.aficiones = aficiones;
    }

    /**
     * @return the roles
     */
    public Collection<Rol> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public boolean esValido() {
        return (getId() != null && getId() > 0
                && getNombre() != null && !getNombre().isBlank());
    }

    public boolean esVacio() {
        return (getNombre() == null || getNombre().isBlank());
    }

}
