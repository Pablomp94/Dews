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
 * Redireccion de /listaProductos a una pagina con el listado de los productos == lista_productos.jsp
 */

@WebServlet(name="listaProductos", urlPatterns={"/listaProductos"})
public class listaProductos extends HttpServlet{
    
    
    protected void processRequet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd;
        
        rd = request.getRequestDispatcher("/tienda/lista_productos.jsp");
        rd.forward(request, response);
    }
}
