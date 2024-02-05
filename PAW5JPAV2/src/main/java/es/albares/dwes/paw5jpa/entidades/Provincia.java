/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5jpa.entidades;

/**
 *
 * @author pablo
 */
public class Provincia {
    
    private String codigo;
    private String nombre;
    
    public Provincia (String codigo, String nombre){
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
        if(obj instanceof Provincia provincia){
            return provincia.getCodigo().equals(this.codigo) && 
                    provincia.getNombre().equals(this.nombre);
        }
        return false;
    }
 
    
}
