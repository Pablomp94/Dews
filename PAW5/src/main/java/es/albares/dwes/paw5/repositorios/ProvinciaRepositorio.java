package es.albares.dwes.paw5.repositorios;

import es.albares.dwes.paw5.dao.ProvinciaDAO;
import es.albares.dwes.paw5.entidades.Provincia;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
@Named("provinciaRepo")
@ApplicationScoped
public class ProvinciaRepositorio {
    
    @Inject
    private ProvinciaDAO provDAO;
    private static List<Provincia> lstProvincias;
    
    private final Object obj = new Object();

    public List<Provincia> getProvincias() {
        if (lstProvincias == null) {
          synchronized (obj) {
            if (lstProvincias == null) {
                try {
                    lstProvincias = provDAO.getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ProvinciaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          }
        }
       return lstProvincias;
    }
}
