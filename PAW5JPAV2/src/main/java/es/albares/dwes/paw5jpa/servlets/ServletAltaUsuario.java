/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albares.dwes.paw5jpa.servlets;

import es.albares.dwes.paw5jpa.entidades.Usuario;
import es.albares.dwes.paw5jpa.servicios.UsuarioServices;
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
 * @author eloy
 */
@WebServlet(name = "ServletAltaUsuario", urlPatterns = {"/usuario/altaUsuario"})
public class ServletAltaUsuario extends HttpServlet {

    @Inject
    UsuarioServices usuarioServ;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = null;
        try {
            usuario = usuarioServ.registraUsuario(
                    request.getParameter("nombre"), request.getParameter("apellidos"),
                    request.getParameter("dni"), request.getParameter("direccion"),
                    request.getParameter("localidad"), request.getParameter("codpostal"),
                    request.getParameter("provincia"), request.getParameter("sexo"),
                    request.getParameterValues("aficiones"), request.getParameter("nacimiento"),
                    request.getParameter("login"), request.getParameter("password"),
                    request.getParameter("password_rep"), request.getParameter("email"));
        } catch (Exception ex) {
            Logger.getLogger(ServletAltaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (usuario != null) {
            response.getWriter().println("Nuevo usuario con ID: " + usuario.getId() + "<br />");
            response.getWriter().println("Se te llevará al inicio en 3 segundos..");
            response.setContentType("text/html; charset=UTF-8"); //defino la respuesta como UTF-8 para que se vean las tildes
            response.setHeader("Refresh", "3; URL=/paw5jpa/usuario/inicio.jsp"); //redirije al inicio en 3 segundos
        } else {
            response.getWriter().println("No se ha podido registrar el usuario con el nombre: "
                    + request.getParameter("nombre"));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
