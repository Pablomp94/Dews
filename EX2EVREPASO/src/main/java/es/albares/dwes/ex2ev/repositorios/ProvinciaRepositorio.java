/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.ex2ev.repositorios;

import es.albares.dwes.ex2ev.dao.ProvinciaDAO;
import es.albares.dwes.ex2ev.entidades.Provincia;
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
    
    public Provincia getProvinciaById(String cod) {
        try {
            return provDAO.getById(cod);
        } catch (SQLException ex) {
            Logger.getLogger(ProvinciaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
