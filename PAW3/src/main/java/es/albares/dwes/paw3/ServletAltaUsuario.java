package es.albares.dwes.paw3;


import es.albares.dwes.paw3.entidades.Usuario;
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
@WebServlet(name = "altaUsuario", urlPatterns = {"/altaUsuario"})
public class ServletAltaUsuario extends HttpServlet {
    
    
    
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getMethod().equalsIgnoreCase("get")) {
            RequestDispatcher rs = request.getRequestDispatcher("/formUsuario.jsp");
            rs.forward(request, response);
        } else {
            UsuarioServices usuServ = new UsuarioServices();
            Usuario usuario = null;
            try {
                usuario = (Usuario) usuServ.creaUsuario(
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
                rs.forward(request, response);

            }

            if (usuario != null) {
                // añadimos un atributo con el objeto persona y nombre "persona"
                request.setAttribute("Usuario", usuario);

                // redirigimos la petición al formulario de usuario
                RequestDispatcher rs = request.getRequestDispatcher("/formUsuario.jsp");
                rs.forward(request, response);
            }
        }

    }

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
        // redirigimos la petición al formulario de persona
        processRequest(request,response);
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
        processRequest(request,response);
    }

}
