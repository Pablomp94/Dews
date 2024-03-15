package es.albares.dwes.ex2ev.tienda;

import es.albares.dwes.ex2ev.entidades.Categoria;
import es.albares.dwes.ex2ev.entidades.Producto;
import es.albares.dwes.ex2ev.servicios.CategoriaServices;
import es.albares.dwes.ex2ev.servicios.ProductoServices;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author usuario
 */
@WebServlet(name="ListaProductosServlet", urlPatterns={"/tienda/listaProductos"})
public class ListaProductosServlet extends HttpServlet {
    
    @Inject
    ProductoServices prodServ;
   
    @Inject
    CategoriaServices catServ;
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // recupera lista de productos mediante el objeto "productoServices" que es inyectado por CDI (alcance aplicación)
        List<Producto> lstProd = (List<Producto>) prodServ.getProductos();
        request.setAttribute("listaProductos", lstProd);
        
        List<Categoria> lstCat = (List<Categoria>) catServ.getCategorias();
        request.setAttribute("listaCategoria", lstCat);
        
        
        
        // pasa el proceso de resolver la petición a la plantilla "lista_productos.jsp"
        RequestDispatcher rd = request.getRequestDispatcher("lista_productos.jsp");
        rd.forward(request, response);
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
