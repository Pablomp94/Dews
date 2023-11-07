package es.albares.dwes.paw3;

import es.albares.dwes.paw3.entidades.Persona;
import es.albares.dwes.paw3.servicios.PersonaServices;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet(name="persona", urlPatterns={"/persona"})
public class ServletPersona extends HttpServlet {
   
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
        // redirigimos la petición al formulario de persona
        RequestDispatcher rs = request.getRequestDispatcher("/formPersonaServlet.jsp");
        rs.forward(request,response);
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
        // llamamos a PersonaServices para pasar los datos del formulario y 
        PersonaServices perServ = new PersonaServices();
        Persona persona = null;
        try {
            persona = perServ.creaPersona(
                    request.getParameter("nombre"), request.getParameter("apellidos"),
                    request.getParameter("dni"), request.getParameter("domicilio"),
                    request.getParameter("localidad"), request.getParameter("municipio"),
                    request.getParameter("codpostal"), request.getParameter("provincia"),
                    request.getParameter("sexo"), request.getParameterValues("aficiones"),
                    request.getParameter("nacimiento"));                    
        } catch (Exception ex) {

            // añadimos un atributo con el texto del error y nombre "error"
            request.setAttribute("error", ex.getMessage());
            
            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("/error.jsp");
            rs.forward(request,response);            
            
        }
        
        if (persona != null) {
            // añadimos un atributo con el objeto persona y nombre "persona"
            request.setAttribute("persona", persona);
            
            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("/viewPersonaServlet.jsp");
            rs.forward(request,response);
        }
    }

}
