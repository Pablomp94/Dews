package es.albares.dwes.paw5.repositorios;

import es.albares.dwes.paw5.dao.RolDAO;
import es.albares.dwes.paw5.entidades.Rol;
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
@Named("rolRepo")
@ApplicationScoped
public class RolRepositorio {
    
    @Inject
    private RolDAO rolDAO;
    private static List<Rol> lstRoles;
    
    private final Object obj = new Object();

    public List<Rol> getAficiones() {
        if (lstRoles == null) {
          synchronized (obj) {
            if (lstRoles == null) {
                try {
                    lstRoles = rolDAO.getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(RolRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          }
        }
       return lstRoles;
    }
}
