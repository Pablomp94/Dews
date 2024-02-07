package es.albares.dwes.paw5.usuario;

import es.albares.dwes.paw5.beans.MensajeBean;
import es.albares.dwes.paw5.entidades.Usuario;
import es.albares.dwes.paw5.beans.UsuarioBean;
import es.albares.dwes.paw5.servicios.UsuarioServices;
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
@WebServlet("/usuario/altaUsuario")
public class AltaUsuarioServlet extends HttpServlet {
    
    @Inject
    UsuarioServices usuarioServ;
    
    @Inject
    UsuarioBean usuarioBean;
    
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
        
        // comprobamos que llega el parámetro idUsuario y que existe un usuario con ese parámetro.
        int idUsuario = -1;
        try {
            idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        } catch (NullPointerException | NumberFormatException ex) {}
        
        if (idUsuario > 0 && usuarioServ.existeUsuario(idUsuario)) {
            // enviamos a la página de inicio con mensaje
            mensajeBean.setMensajeInfo("Usuario registrado correctamente");
            RequestDispatcher rs = request.getRequestDispatcher("inicio.jsp");
            rs.forward(request,response);            
        } else {
            // añadimos un atributo con el texto del error y nombre "error"
            request.setAttribute("error", "Error tras alta de usuario.");

            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
            rs.forward(request,response);
        }

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
        // parametro para la invocación GET de respuesta tras redirect (Patron PRG)
        int idUsuario = 0;
        
        // comprobamos si hay usuario en la sesión
        if (usuarioBean.getNombre() != null && !usuarioBean.getNombre().isBlank()) {
            // añadimos un atributo con el texto del error y nombre "error"
            request.setAttribute("error", "El usuario ya está dado de alta");

            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
            rs.forward(request,response);
        } else {
            try {
                Usuario usuario = usuarioServ.registraUsuario( 
                        request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("dni"), 
                        request.getParameter("direccion"), request.getParameter("localidad"), 
                        request.getParameter("codpostal"), request.getParameter("provincia"),
                        request.getParameter("sexo"), request.getParameterValues("aficiones"), request.getParameter("nacimiento"),
                        request.getParameter("login"), request.getParameter("password"), request.getParameter("password_rep"), request.getParameter("email"));
                idUsuario = usuario.getId();
            } catch (Exception ex) {

                // añadimos un atributo con el texto del error y nombre "error"
                request.setAttribute("error", ex.getMessage());

                // redirigimos la petición al formulario de persona
                RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
                rs.forward(request,response);
            }
        }
        
        // redirigimos a la página de altaUsuario por GET
        response.sendRedirect(request.getContextPath() + "/usuario/altaUsuario?idUsuario=" + idUsuario);
    }
    
}
