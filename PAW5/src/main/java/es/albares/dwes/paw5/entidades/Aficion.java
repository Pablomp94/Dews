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
public class Aficion implements Serializable{
    
    private static long serialVersionUID = 1L; // versión de la entidad{
    
    private String nombre;
    
    
    public Aficion(String nombre){
        this.nombre = nombre;
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
        if (obj instanceof Aficion aficion){
            return (aficion.getNombre().equals(nombre));
        }
        return false;
    }
}
