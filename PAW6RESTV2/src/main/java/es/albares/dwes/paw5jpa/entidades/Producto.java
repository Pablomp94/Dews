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
 * @author usuario
 */
@Entity
public class Producto implements Serializable  {
    
    @Id
    private String id;
    private String marca;
    private String modelo;
    private String imagenUrl;
    private String caracteristicas;
    @Basic(fetch = FetchType.LAZY)
    private String especificaciones;
    @Column(name="fecha_lanzamiento")
    private Date fechaLanzamiento;
    private BigDecimal precio;
    @ManyToOne
    @JoinColumn(name="categoria_codigo")
    private Categoria categoria;

    public Producto() {}
    
    public Producto(String id, String marca, String modelo, String imagenUrl, String caracteristicas, String especificaciones, Date fechaLanz, BigDecimal precio, Categoria cat) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.imagenUrl = imagenUrl;
        this.caracteristicas = caracteristicas;
        this.especificaciones = especificaciones;
        this.fechaLanzamiento = fechaLanz;
        this.precio = precio;
        this.categoria = cat;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }    
    
    public String getTitulo() {
        return this.marca + " " + this.modelo + " " + this.caracteristicas;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
