package es.albares.dwes.paw5.resources;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class Producto {
    
    private String id;
    private String marca;
    private String modelo;
    private String imagenUrl;
    private String caracteristicas;
    private String especificaciones;
    private Date fechaLanzamiento;
    private Float precio;

    public Producto(String id, String marca, String modelo, String imagenUrl, String caracteristicas, String especificaciones, Date fechaLanz, Float precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.imagenUrl = imagenUrl;
        this.caracteristicas = caracteristicas;
        this.especificaciones = especificaciones;
        this.fechaLanzamiento = fechaLanz;
        this.precio = precio;
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

    public void setEspecificaciones(String especificacioness) {
        this.especificaciones = especificaciones;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }    
    
    public String getTitulo() {
        return this.marca + " " + this.modelo + " " + this.caracteristicas;
    }
    
}
