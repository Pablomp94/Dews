
import es.albares.dwes.paw5.servicios.ProductoServices;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */





/**
 *
 * @author Pablo
 */
@WebServlet(name = "/tienda/altaProductos", urlPatterns = {"/tienda/altaProductos"})
public class AltaProductosServlet extends HttpServlet {

        ProductoServices.altaProductos();
    
    
}

    
  
