package es.albares.dwes.paw5.usuario;

import es.albares.dwes.paw5.beans.MensajeBean;
import es.albares.dwes.paw5.beans.UsuarioBean;
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

@WebServlet("/usuario/cerrarSesion")
public class CerrarSesionServlet extends HttpServlet {
    
    @Inject
    MensajeBean mensajeBean;
    
    @Inject
    UsuarioBean usuarioBean;
    
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
        
        // invalidar la sesion no tiene efecto al no hacer redirect
        // es conveniente hacer un cambio de identificador para que en la carga no use el mismo id
        request.getSession().invalidate();
        
        mensajeBean.setMensajeAviso("Sesión cerrada con éxito");
        usuarioBean.descartar();
        RequestDispatcher rs = request.getRequestDispatcher("inicio.jsp");
        rs.forward(request,response);
    }
}
