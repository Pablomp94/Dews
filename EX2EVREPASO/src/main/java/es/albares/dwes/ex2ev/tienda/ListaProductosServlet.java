package es.albares.dwes.ex2ev.tienda;

import es.albares.dwes.ex2ev.entidades.Categoria;
import es.albares.dwes.ex2ev.entidades.Producto;
import es.albares.dwes.ex2ev.servicios.CategoriaServices;
import es.albares.dwes.ex2ev.servicios.ProductoServices;
import es.albares.dwes.ws.cliente.generated.ProductosDestacadosWS;
import es.albares.dwes.ws.cliente.generated.ProductosDestacadosWebService;
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

        
        ProductosDestacadosWebService pdws = new ProductosDestacadosWebService();
        ProductosDestacadosWS pd = pdws.getProductosDestacadosWSPort();
        List<String> lstDestacados = pd.destacados();
        
        request.setAttribute("listaDestacados", lstDestacados);
        
        
        
        
        
        //Comprobamos los parametros: "categoria" y "stock" del formulario de listaProductos
        String paramCateg = request.getParameter("categoria");
        String paramStock = request.getParameter("stock");
        
        //Recupera la lista Productos
        List<Producto> lstProd;
        
        if(paramCateg != null && !paramCateg.isBlank()){ //Llega una categoria
            if("S".equals(paramStock)){//Solo produtos con existencias
                lstProd = (List<Producto>) prodServ.getProductosByCategoriaEnStock(paramCateg);
            }else{
                lstProd = (List<Producto>) prodServ.getProductosByCategoria(paramCateg);
            }
        }else{//No llega categoria
            if("S".equals(paramStock)){//Solo produtos con existencias
                lstProd = (List<Producto>) prodServ.getProductosEnStock();
            }else{
                lstProd = (List<Producto>) prodServ.getProductos();
            }
        }

        request.setAttribute("listaProductos", lstProd);
        
        //Obtengo la lista de Categorias y las paso como atributo para la vista
        List<Categoria> lstCat = (List<Categoria>) catServ.getCategorias();
        request.setAttribute("listaCategorias", lstCat);
        
        
        
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
