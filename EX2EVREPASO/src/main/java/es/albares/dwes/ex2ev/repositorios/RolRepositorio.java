/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.ex2ev.repositorios;

import es.albares.dwes.ex2ev.dao.RolDAO;
import es.albares.dwes.ex2ev.entidades.Rol;
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
    
    // almacena copia de la lista de roles temporalmente
    private static List<Rol> lstRoles;

    public List<Rol> getAficiones() {
        if (lstRoles == null) {
          synchronized (this) {
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
    
    public void resetRoles() {
        synchronized (this) {
            lstRoles = null;
        }
    }
}
