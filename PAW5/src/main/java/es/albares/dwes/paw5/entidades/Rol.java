/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.entidades;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public class Rol implements Serializable {
    
    private static long serialVersionUID = 1L; // versión de la entidad{
    
    private String codigo;
    private String nombre;

    
    public Rol(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rol rol){
            return(rol.getCodigo().equals(codigo) &&
                    rol.getNombre().equals(nombre));
        }
        return false;
    }
}
