package es.albares.dwes.paw5.usuario;


import es.albares.dwes.paw5.entidades.Usuario;
import es.albares.dwes.paw5.servicios.UsuarioServices;
import jakarta.inject.Inject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
@WebServlet(name="altaUsuario", urlPatterns={"/altaUsuario"})
public class AltaUsuarioServlet extends HttpServlet {
    
    
    @Inject
    UsuarioServices usuarioServ;
   

    

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
        
        
    try{
        Usuario usuario = usuarioServ.registraUsuario(LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, aficiones, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD);
            
    }catch (Exception ex){
        Logger.getLogger(AltaUsuario.class.getName().log(Level.SEVERE, ))
    }
        
    }
}
