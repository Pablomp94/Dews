/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw6ws.entidades;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Aficion implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String nombre;

    public Aficion() {
    }

    public Aficion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Aficion aficion) {
            return aficion.getNombre().equalsIgnoreCase(nombre);
        } else return false;
    }
    
    

}
