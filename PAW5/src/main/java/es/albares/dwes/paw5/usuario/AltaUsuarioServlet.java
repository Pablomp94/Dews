package es.albares.dwes.paw5.usuario;

import es.albares.dwes.paw5.beans.UsuarioBean;
import es.albares.dwes.paw5.entidades.Usuario;
import es.albares.dwes.paw5.servicios.UsuarioServices;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
@WebServlet(name="altaUsuario", urlPatterns={"usuario/altaUsuario"})
public class AltaUsuarioServlet extends HttpServlet {
    
    
    @Inject
    UsuarioServices usuarioServ;
   

    @Inject
    UsuarioBean usuario;
    

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AltaUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AltaUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, SQLException {
        
        // comprobamos si hay usuario en la sesión
        if (usuario.getNombre() != null && !usuario.getNombre().isBlank()) {
            // añadimos un atributo con el texto del error y nombre "error"
            request.setAttribute("error", "El usuario ya está dado de alta");

            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("/error.jsp");
            rs.forward(request,response);
            return;
        } else {
            
            PreparedStatement ptm = null;
            ResultSet rs = null;
            rs = ptm.executeQuery();
            // vienen parámetros del formulario... (suponemos que sí
            // llamamos a PersonaServices para crear una persona con los datos del formulario
            try{
                Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("apellidos"), rs.getString("sexo"),
                        rs.getDate("fecha_nacimiento"), rs.getString("dni"),
                        rs.getString("login"), null, rs.getString("email"),
                        rs.getDate("fecha_registro"));                    
            } catch (Exception ex) {

                // añadimos un atributo con el texto del error y nombre "error"
                request.setAttribute("error", ex.getMessage());

                // redirigimos la petición al formulario de persona
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request,response);
                return;
            }
        }
        
        // redirigimos a la página de inicio
        response.sendRedirect(request.getContextPath() + "/usuario/inicio.jsp");
    }
}
