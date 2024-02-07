package es.albares.dwes.paw5.servicios;

import es.albares.dwes.paw5.entidades.Categoria;
import es.albares.dwes.paw5.entidades.Producto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author usuario
 */
@Named("productoServices")
@ApplicationScoped
public class ProductoServices {

    private HashMap<String, Producto> mapProductos;

    public ProductoServices() {
        synchronized (this) {
            if (mapProductos == null) {
                getStaticProducts();
            }
        }
    }

    // damos de alta los productos desde su carga "local"
    public void altaProductos() {
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        // damos da alta los productos en BD (si no existen...)
        entityManager.getTransaction().begin();
        try {
            for (Producto prod : getStaticProducts()) {
                entityManager.merge(prod);
            }
            entityManager.getTransaction().commit();
        } catch (Exception EX) {
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    

    public class GestorEntityManager {

        public static EntityManager getEntityManager() {
            return Persistence.createEntityManagerFactory("tienda").createEntityManager();
        }
    }

    public Collection<Producto> getProductos() {
        return mapProductos.values();
    }

    /**
     * Inicializa la lita de productos con una colección de ejemplo
     */
    private List<Producto> getStaticProducts() {

        EntityManager entityManager = GestorEntityManager.getEntityManager();
        Categoria catMovil = entityManager.find(Categoria.class, "Movil");
        entityManager.close();
        return null;
    }

    /**
     * Devuelve el Producto que es identificado por el parámetro Id
     *
     * @param id
     * @return
     */
    public Producto getProductoById(String id) {
        return mapProductos.get(id);
    }

}
