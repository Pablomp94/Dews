package es.albares.dwes.paw5.usuario;

import es.albares.dwes.paw5.beans.MensajeBean;
import es.albares.dwes.paw5.entidades.Usuario;
import es.albares.dwes.paw5.beans.UsuarioBean;
import es.albares.dwes.paw5.servicios.UsuarioServices;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet("/usuario/login")
public class LoginServlet extends HttpServlet {
        
    @Inject
    UsuarioServices usuarioServ;
    
    @Inject
    UsuarioBean usuarioBean;
    
    @Inject
    MensajeBean mensajeBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        if (usuarioBean.esValido()) {
            response.sendRedirect(request.getContextPath() + "/usuario/inicio.jsp"); 
        } else {
            response.sendRedirect(request.getContextPath() + "/usuario/login.jsp");
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        
        Usuario usuario;

        try {

            String login = request.getParameter("login");
            String passw = request.getParameter("password");

            usuario = usuarioServ.obtenerUsuario(login, passw);

            if (usuario.esValido()) {
                usuarioBean.copiar(usuario);
                mensajeBean.setMensajeInfo("Usuario autenticado correctamente");
                RequestDispatcher rs = request.getRequestDispatcher("inicio.jsp");
                rs.forward(request,response);
            } else {
                request.setAttribute("error", "Usuario no encontrado");

                // redirigimos la petición al formulario de persona
                RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
                rs.forward(request,response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Error obteniendo Usuario: " + ex.getMessage() );

            // redirigimos la petición al formulario de persona
            RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
            rs.forward(request,response);
        }
    }    
}
