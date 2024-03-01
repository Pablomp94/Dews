package es.albares.dwes.paw6ws.tienda;

import es.albares.dwes.paw6ws.entidades.Producto;
import es.albares.dwes.paw6ws.servicios.ProductoServices;
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
@WebServlet("/tienda/producto")
public class ProductoServlet extends HttpServlet {
    
    @Inject
    ProductoServices prodServ;
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // recupera el parámetro "idProducto" que llega en la URL de la petición
        String paramIdProducto = request.getParameter("idProducto");
        
        // recupera el producto asociado al parámetro
        Producto prod = prodServ.getProductoById(paramIdProducto);
        
        if (prod != null) {
            // añade el producto recuperado como atributo a la petición, para ser usado en la vista
            request.setAttribute("producto", prod);
            
            RequestDispatcher rd = request.getRequestDispatcher("producto.jsp");
            rd.forward(request, response);
        } // else --> se trataría el caso de que el idProducto fuera incorrecto y no correspondiera a ningún producto
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
