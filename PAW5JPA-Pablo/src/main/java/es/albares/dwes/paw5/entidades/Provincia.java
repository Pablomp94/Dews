package es.albares.dwes.paw5.entidades;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Provincia implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String nombre;

    public Provincia() {
    }

    public Provincia(String codigo) {
        this.codigo = codigo;
    }

    public Provincia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
