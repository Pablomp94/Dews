/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.beans;

import es.albares.dwes.paw5.entidades.Usuario;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author Pablo
 */

@Named("usuarioBean")
@SessionScoped
public class UsuarioBean extends Usuario {
    
 private static final long serialVersionUID = 1L;
 
 private Integer id;

 public UsuarioBean() {
     
 }
 
 
 public UsuarioBean (Integer id) {
        this.id = id;
    }
 
 @Override
 public Integer getId(){
     return id;
 }
public void setUsuarioBean(Integer id) {
    this.id = id;
}
 
 
 public void descartar() {
 this.setId(null);
 }

 public void copiar(Usuario user) {
 this.setId(user.getId());
 this.setNombre(user.getNombre());
 this.setApellidos(user.getApellidos());
 this.setDni(user.getDni());
 this.setFechaNacimiento(user.getFechaNacimiento());
 this.setFechaRegistro(user.getFechaRegistro());
 this.setSexo(user.getSexo());
 this.setLogin(user.getLogin());
 this.setEmail(user.getEmail());
 this.setDirecciones(user.getDirecciones());
 this.setAficiones(user.getAficiones());
 this.setRoles(user.getRoles());
 }
}