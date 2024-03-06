/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.ex2ev.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
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

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nombre, String apellidos, String sexo, Date fechaNacimiento, String dni, String login, String password, String email, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = Sexo.valueOf(sexo);
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = Sexo.valueOf(sexo);
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public Collection<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Collection<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public Collection<Aficion> getAficiones() {
        return aficiones;
    }

    public void setAficiones(Collection<Aficion> aficiones) {
        this.aficiones = aficiones;
    }    
    
    public boolean esValido() {
        return (getId() != null && getId() > 0 
                && getNombre() != null && !getNombre().isBlank());
    }
    
    public boolean esVacio() {
        return (getNombre() == null || getNombre().isBlank());
    }
    
}
