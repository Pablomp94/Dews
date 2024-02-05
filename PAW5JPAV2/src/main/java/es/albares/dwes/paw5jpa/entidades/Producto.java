/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5jpa.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author pablo
 */
@Entity
public class Producto implements Serializable {

    @Id
    private String id;
    private String marca;
    private String modelo;
    private String imagenUrl;
    private String caracteristicas;
    
    @Basic(fetch = FetchType.LAZY)
    private String especificaciones;
    
    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;
    private BigDecimal precio;
    
    @ManyToOne
    @JoinColumn(name = "categoria_codigo")
    private Categoria categoria;
    
    public Producto(){}

    public Producto(String id, String marca, String modelo, String imagenUrl, String caracteristicas, 
            String especificaciones, Date fechaLanzamiento, BigDecimal precio, Categoria categoria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.imagenUrl = imagenUrl;
        this.caracteristicas = caracteristicas;
        this.especificaciones = especificaciones;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the imagenUrl
     */
    public String getImagenUrl() {
        return imagenUrl;
    }

    /**
     * @param imagenUrl the imagenUrl to set
     */
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    /**
     * @return the caracteristicas
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**
     * @return the especificaciones
     */
    public String getEspecificaciones() {
        return especificaciones;
    }

    /**
     * @param especificaciones the especificaciones to set
     */
    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    /**
     * @return the fechaLanzamiento
     */
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * @param fechaLanzamiento the fechaLanzamiento to set
     */
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
 
    
    
}
