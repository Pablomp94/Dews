package es.albares.dwes.paw3;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author usuario
 */
@WebServlet(name = "contador", urlPatterns = {"/contador"})
public class ServletIncContador extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // *** ATRIBUTO DE PETICION ***
        // obtenemos el valor del contador 
        AtomicInteger contadorPeticion = null;
        try {
            contadorPeticion = (AtomicInteger) request.getAttribute("contadorRequest");
            // el "cast" de un objeto null generaría excepción ClassCastException   
        } catch (Exception ex) {}
        // si no exite el contador
        if (contadorPeticion == null) {
            // inicializamos el atributo de petición 
            request.setAttribute("contadorRequest", new AtomicInteger(0));
        }
        
        // *** ATRIBUTO DE SESION ***
        // obtenemos sesion y el atributo de sesión
        AtomicInteger contadorSesion = null;
        // comprobamos si había ya atributo de sesión
        try {
            contadorSesion = (AtomicInteger) request.getSession().getAttribute("contadorSession");
            // el "cast" de un objeto null generaría excepción ClassCastException   
        } catch (Exception ex) {}
        
        if (contadorSesion == null) {
            // no hay contador de sesion lo inicializamos 
            request.getSession().setAttribute("contadorSession", new AtomicInteger(0));
        }        
        
        // *** ATRIBUTO DE APLICACION ***
        // obtenemos el atributo de aplicación
        AtomicInteger contadorAplicacion = null;
        // comprobamos si había ya atributo de aplicacion
        try {
            contadorAplicacion = (AtomicInteger) getServletContext().getAttribute("contadorApplication");
            // el "cast" de un objeto null generaría excepción ClassCastException   
        } catch (Exception ex) {}
        
        if (contadorAplicacion == null) {
            // no hay contador de aplicacion
            getServletContext().setAttribute("contadorApplication", new AtomicInteger(0));
        }   
        
        
        // recuperamos parámetro "incrementa"
        String paramIncrementa = request.getParameter("incrementa");        
        
        // si llegan parámetro incrementa => evaluamos e incrementamos contador correspondiente
        if (paramIncrementa != null && !paramIncrementa.isBlank()) {
            switch (paramIncrementa) {
                case "request":
                    try {
                        ((AtomicInteger) request.getAttribute("contadorRequest")).incrementAndGet();
                    } catch (Exception ex) {}
                    break;
                case "session":
                    try {
                        ((AtomicInteger) request.getSession().getAttribute("contadorSession")).incrementAndGet();
                    } catch (Exception ex) {}
                    break;
                case "application":
                    try {
                        ((AtomicInteger) getServletContext().getAttribute("contadorApplication")).incrementAndGet();
                    } catch (Exception ex) {}
                    break;
                default:
                    break;
            }
        }
        // redirigimos la petición al formulario de persona
        RequestDispatcher rs = request.getRequestDispatcher("/contadores.jsp");
        rs.forward(request,response);        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
