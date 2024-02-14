/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author Pablo
 */
@Named("rolRepo")
@ApplicationScoped
public class RolRepositorio {

    @Inject
    private RolDAO provDAO;
    private static List<Rol> lstRoles;

    private final Object obj = new Object();

    public List<Rol> getRoles() {
        if (lstRoles == null) {
            synchronized (obj) {
                if (lstRoles == null) {
                    try {
                        lstRoles = provDAO.getAll();
                    } catch (SQLException ex) {
                        Logger.getLogger("RolRepositorio").log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return lstRoles;
    }
}
