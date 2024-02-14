package es.albares.dwes.paw5jpa.tienda;

import es.albares.dwes.paw5jpa.beans.MensajeBean;
import es.albares.dwes.paw5jpa.servicios.ProductoServices;
import jakarta.inject.Inject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet("/tienda/altaProductos")
public class AltaProductosServlet extends HttpServlet {
    
    @Inject
    ProductoServices productoServ;
       
    @Inject
    MensajeBean mensajeBean;
    

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
    
        productoServ.altaProductos();
        
        // enviamos a la página de inicio con mensaje
        mensajeBean.setMensajeInfo("Productos registrados correctamente");
        
        response.sendRedirect(request.getContextPath() + "/tienda/listaProductos");
    }
}
