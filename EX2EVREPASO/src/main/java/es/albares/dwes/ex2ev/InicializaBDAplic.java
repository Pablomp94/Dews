package es.albares.dwes.paw6ws;

import es.albares.dwes.ex2ev.basedatos.GestorConexion;
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
