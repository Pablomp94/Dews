package es.albares.dwes.ex2ev.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
@Table(name="Producto_existencias")
public class ProductoExistencias implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "producto_id")
    private String id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    private Integer cantidad = 0;

    public ProductoExistencias() {
    }

    public ProductoExistencias(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * @return the producto
     */
    @XmlTransient
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

}
