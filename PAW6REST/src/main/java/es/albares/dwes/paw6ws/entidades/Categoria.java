/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw6ws.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author usuario
 */
@Entity
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private String codigo;
    private String nombre;
    
    @OneToMany(mappedBy="categoria")
    private List<Producto> listaProductos;

    public Categoria() {
        super();
        listaProductos = new ArrayList<>();
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public List<Producto> getListaProductos() {
        return listaProductos;
    }
    
    public void setListaProdutos(List<Producto> lstProd) {
        listaProductos = lstProd;
    }
            

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Categoria cat) {
            return (cat.getCodigo().equalsIgnoreCase(codigo) && 
                    cat.getNombre().equalsIgnoreCase(nombre));
        } else return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
}
