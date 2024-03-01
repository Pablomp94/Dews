package es.albares.dwes.ex1evepaso.tienda;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author usuario
 */
public class CarroProductos implements Serializable {
    
    private final HashMap<String, Integer> mapCarroProductos = new HashMap<>();
    
    public CarroProductos() {
    }
    
    /**
     * Devuelve la lista de Ids de los productos del carro.
     * @return 
     */
    public Collection<String> getIdProductos() {
        return mapCarroProductos.keySet();
    }
    
    /**
     * Devuelve la cantidad incluida en el carro para un Producto concreto identificado por su Id. Si no está en el carro devuelve 0.
     * @param id identificador del producto
     * @return 
     */
    public int getCantidadProductoById(String id) {
        return mapCarroProductos.getOrDefault(id, 0);
    }
    
    /**
     * Añade al carro el Producto especificado por su id.
     * @param id identificador del producto
     */
    public synchronized void anyadeProducto(String id) {
        mapCarroProductos.put(id, mapCarroProductos.getOrDefault(id, 0) + 1);
    }
    
    /**
     * Substrae del carro un Producto especificado por su id.
     * @param id identificador del producto
     */
    public synchronized void substraeProducto(String id) {
        int cantidad = this.getCantidadProductoById(id);
        if (cantidad > 1) {
            mapCarroProductos.put(id, cantidad - 1);
        } else {
            mapCarroProductos.remove(id);
        }
    }

    /**
     * Borra del carro un Producto especificado por su id.
     * @param id identificador del producto
     */
    public synchronized void borraProducto(String id) {
        mapCarroProductos.remove(id);
    }
    
    
}
