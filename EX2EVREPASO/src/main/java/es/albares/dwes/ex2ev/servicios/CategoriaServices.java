package es.albares.dwes.ex2ev.servicios;

import es.albares.dwes.ex2ev.basedatos.GestorEntityManager;
import es.albares.dwes.ex2ev.entidades.Categoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author usuario
 */

@ApplicationScoped
public class CategoriaServices {

    public CategoriaServices() {
    }

    /**
     * Devuelve la lista completa de categorias de la BD
     *
     * @return la lista de categorias
     */
    public Collection<Categoria> getCategorias() {
        EntityManager entityManager = GestorEntityManager.getEntityManager();
        List<Categoria> lstCat = entityManager.createQuery("SELECT distinct c from Categoria c", Categoria.class).getResultList();
        entityManager.close();

        return lstCat;
    }

    /*
    public Producto getCategoriaByCodigo(String id) {
        if (id != null) {
            EntityManager entityManager = GestorEntityManager.getEntityManager();
            Producto Prod = entityManager.find(Producto.class, id);
            entityManager.close();
            return Prod;
        } else {
            return null;
        }
    }
    */
   

}
