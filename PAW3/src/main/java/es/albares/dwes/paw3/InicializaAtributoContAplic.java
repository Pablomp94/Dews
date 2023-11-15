/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pablo
 */
package es.albares.dwes.paw3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class InicializaAtributoContAplic implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Obtén el contexto de la aplicación
        ServletContext context = sce.getServletContext();

        // Inicializa el contador de la aplicación
        AtomicInteger contadorAplicacion = new AtomicInteger(0);

        // Guárdalo como atributo del contexto de la aplicación
        context.setAttribute("contadorApplication", contadorAplicacion);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Este método puede quedarse vacío, ya que no necesitamos hacer nada al destruir el contexto de la aplicación.
    }
}
