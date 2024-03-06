package es.albares.dwes.ex2ev.tienda;

import es.albares.dwes.ex2ev.beans.MensajeBean;
import es.albares.dwes.ex2ev.entidades.CarroProductos;
import es.albares.dwes.ex2ev.entidades.Producto;
import es.albares.dwes.ex2ev.servicios.ProductoServices;
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
@WebServlet(urlPatterns = {"/tienda/carro", "/tienda/verCarrito"})
public class CarritoServlet extends HttpServlet {
       
    @Inject
    ProductoServices prodServ;
    
    // el objeto "carrito" se injecta de un beans al que se le ha definido alcance de "sesión"
    //  por lo que cada instancia corresponde a un usuario distinto (cada usuario tiene su propio carro de la compra)
    @Inject
    CarroProductos carrito;
    
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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Recuperamos los parámetros necesarios para identificar la acción a realizar y el producto sobre el que se realiza
        // Estos parámetros los hemos definido en la vista del producto, para el botón de añadir (también se usarán en el carro)
        String paramIdProducto = request.getParameter("idProducto");
        String paramAccion = request.getParameter("accion");
        
        if (paramIdProducto != null) {
            // intentamos obtener el producto correspondiente al id recibido
            Producto prod = prodServ.getProductoById(paramIdProducto);

            // comprobamos que existe un producto asociado al idProducto (el parámetro es correcto)
            if (prod != null) {

                switch (paramAccion) {
                    case "anyadir" -> carrito.anyadeProducto(paramIdProducto);
                    case "substraer" -> carrito.substraeProducto(paramIdProducto);
                    case "borrar" -> carrito.borraProducto(paramIdProducto);
                    default -> throw new AssertionError();
                }

            } else {
                // no es correcto el idProducto
                // añadimos un atributo con el texto del error y nombre "error"
                request.setAttribute("error", "Error al obtener producto para el carro.");

                // redirigimos la petición al formulario de persona
                RequestDispatcher rs = request.getRequestDispatcher("../usuario/error.jsp");
                rs.forward(request,response);
                return;
            }
        }
        
        // mostramos el carro de compra llevando la ejecución a la vista del carro 
        RequestDispatcher rd = request.getRequestDispatcher("carroCompra.jsp");
        rd.forward(request, response);

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
