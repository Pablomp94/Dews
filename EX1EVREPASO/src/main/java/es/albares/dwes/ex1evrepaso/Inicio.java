/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.ex1evrepaso;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Pablo
 * Realizo la redirección correspondiente a la url /inicio a inicio.html
 */

//Indico la ruta a hacer la redireccion//
@WebServlet(name ="inicio", urlPatterns = {"/inicio"})
public class Inicio extends HttpServlet{
    
    //Hago la redireccion//

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd;
        
        rd = request.getRequestDispatcher("/tienda/inicio.jsp");
        rd.forward(request, response);
        
    }
}
