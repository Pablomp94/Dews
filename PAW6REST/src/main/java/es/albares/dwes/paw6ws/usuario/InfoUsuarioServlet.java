package es.albares.dwes.paw6ws.usuario;

import es.albares.dwes.paw6ws.beans.UsuarioBean;
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

@WebServlet("/usuario/infoUsuario")
public class InfoUsuarioServlet extends HttpServlet {
    
    @Inject
    UsuarioBean  usuarioBean;
    
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
        if (usuarioBean.esValido()) {
            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("viewUsuario.jsp");
            rs.forward(request,response);
        } else {
            // añadimos un atributo con el texto del error y nombre "error"
            request.setAttribute("error", "No hay datos de usuario");

            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
            rs.forward(request,response);
        }
    }
}
