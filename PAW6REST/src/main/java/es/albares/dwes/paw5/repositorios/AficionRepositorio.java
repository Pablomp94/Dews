/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.repositorios;

import es.albares.dwes.paw5.dao.AficionDAO;
import es.albares.dwes.paw5.entidades.Aficion;
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
@Named("aficionRepo")
@ApplicationScoped
public class AficionRepositorio {

    @Inject
    private AficionDAO provDAO;
    private static List<Aficion> lstAficiones;

    private final Object obj = new Object();

    public List<Aficion> getAficions() {
        if (lstAficiones == null) {
            synchronized (obj) {
                if (lstAficiones == null) {
                    try {
                        lstAficiones = provDAO.getAll();
                    } catch (SQLException ex) {
                        Logger.getLogger("AficionRepositorio").log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return lstAficiones;
    }
}
