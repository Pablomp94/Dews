package es.albares.dwes.paw3.usuario;

import es.albares.dwes.paw3.entidades.Persona;
import es.albares.dwes.paw3.servicios.PersonaServices;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author usuario
 */
@WebServlet(name="altaUsuario", urlPatterns={"/altaUsuario"})
public class ServletAltaUsuario extends HttpServlet {
   
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
        HttpSession sesion = request.getSession(false);
        Persona usuario = null;
        if (sesion != null) {
            try {    
                usuario = (Persona) sesion.getAttribute("usuario");
                if (usuario != null) {
                    // añadimos un atributo con el texto del error y nombre "error"
                    request.setAttribute("error", "El usuario ya está dado de alta");

                    // redirigimos la petición al formulario de persona
                    RequestDispatcher rs = request.getRequestDispatcher("/error.jsp");
                    rs.forward(request,response);
                }                        
            } catch (Exception ex) {
                // en lugar de recuperar un Object y comprobar si es un instanceof Persona, capturamos la posible excepcion y seguimos
                request.setAttribute("error", "Se ha producido un error al recuperar los datos del usuario");

                // redirigimos la petición al formulario de persona
                RequestDispatcher rs = request.getRequestDispatcher("/error.jsp");
                rs.forward(request,response);
            }
        }

        // si el usuario es nulo seguimos con la ejecución normal
        if (usuario == null) {
            // vienen parámetros del formulario...
            // llamamos a PersonaServices para crear una persona con los datos del formulario
            PersonaServices perServ = new PersonaServices();
            try {
                usuario = perServ.creaPersona(
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

            if (usuario != null) {
                if (sesion == null) {
                    sesion = request.getSession();
                }
                // añadimos la persona como usuario de sesion
                sesion.setAttribute("usuario", usuario);
            }
        }
        
        if (usuario != null) {
            // redirigimos a la página de inicio
            response.sendRedirect(request.getContextPath() + "/usuario/inicio.jsp");
        }
    }
}
