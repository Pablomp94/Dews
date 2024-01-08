package es.albares.dwes.paw4.usuario;

import es.albares.dwes.paw4.entidades.Persona;
import es.albares.dwes.paw4.servicios.PersonaServices;
import jakarta.inject.Inject;
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
@WebServlet(name="altaUsuario", urlPatterns={"/altaUsuario"})
public class ServletAltaUsuario extends HttpServlet {
    
    @Inject
    PersonaServices perServ;
    
    @Inject
    Persona usuario;

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
        
        // comprobamos si hay usuario en la sesión
        if (usuario.getNombre() != null && !usuario.getNombre().isBlank()) {
            // añadimos un atributo con el texto del error y nombre "error"
            request.setAttribute("error", "El usuario ya está dado de alta");

            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("/error.jsp");
            rs.forward(request,response);
            return;
        } else {
            // vienen parámetros del formulario... (suponemos que sí
            // llamamos a PersonaServices para crear una persona con los datos del formulario
            try {
                perServ.creaPersona(usuario,
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
                return;
            }
        }
        
        // redirigimos a la página de inicio
        response.sendRedirect(request.getContextPath() + "/usuario/inicio.jsp");
    }
}
