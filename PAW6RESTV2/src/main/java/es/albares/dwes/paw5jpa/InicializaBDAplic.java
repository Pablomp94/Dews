package es.albares.dwes.paw5jpa;

import es.albares.dwes.paw5jpa.basedatos.GestorConexion;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener 
public class InicializaBDAplic implements ServletContextListener {
    
   @Inject
   GestorConexion cm;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce); 
        cm.initDS();        
    }
   
}
