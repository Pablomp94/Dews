/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5jpa.basedatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 *
 * @author jans7
 */
public class GestorEntityManager {
    
    public static EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("tienda").createEntityManager();
    }
}
