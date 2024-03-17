package es.albares.dwes.ex2ev.resources;


import es.albares.dwes.ex2ev.entidades.Producto;
import es.albares.dwes.ex2ev.servicios.ProductoServices;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/producto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoResources {

    // Devuelve lista de Producto
    @GET
    public List<Producto> getProducto() {
        ProductoServices prodServ = CDI.current().select(ProductoServices.class).get();
        try {
            return (List<Producto>) prodServ.getProductos();
        } catch (Exception ex) {
            Logger.getLogger(ProductoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Path("/{idProd}")    
    // Obtiene Rol por su clave primaria
    public Producto getProductoById(@PathParam("idProd") String idProd){
        ProductoServices prodServ = CDI.current().select(ProductoServices.class).get();
        try {
            return prodServ.getProductoById(idProd);
        } catch (Exception ex) {
            Logger.getLogger(ProductoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("/cat/{cat_codigo}")
    public List<Producto> getProductosByCodCat (@PathParam("cat_codigo") String codCat){
        ProductoServices prodServ = CDI.current().select(ProductoServices.class).get();
        try{
            return (List<Producto>) prodServ.getProductosByCategoria(codCat);
        }catch(Exception ex){
           Logger.getLogger(ProductoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    // devuelve el codigo del producto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertProducto(Producto producto){
        ProductoServices prodServ = CDI.current().select(ProductoServices.class).get();
        try {
            prodServ.insertProducto(producto);
            return producto.getId();
        } catch (Exception ex) {
            Logger.getLogger(ProductoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Devuelve el número de filas insertado (será 1 si es actualizado)
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer updateProducto(Producto producto){
        ProductoServices prodServ = CDI.current().select(ProductoServices.class).get();
        try {
            return prodServ.updateProducto(producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    // Devuelve el número de filas borrado (será 1 si es borrado)
    @DELETE
    @Path("/{idProd}")
    public Integer deleteProducto(@PathParam("idProd") String idProducto){
        ProductoServices prodServ = CDI.current().select(ProductoServices.class).get();
        try {
            return prodServ.deleteProducto(idProducto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @PUT
    @Path("/{id_producto}/inc/{cantidad}")
    public Integer  incrementaProducto(@PathParam("id_producto") String id_producto, @PathParam("cantidad") int cantidad){
        ProductoServices prodServ = CDI.current().select(ProductoServices.class).get();
        try {
            return prodServ.incrementa(id_producto, cantidad);
        } catch (Exception ex) {
            Logger.getLogger(ProductoResources.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
    
    
    @PUT
    @Path("/{id_producto}/dec/{cantidad}")
    public Integer decrementaProducto(@PathParam("id_producto") String id_producto, @PathParam("cantidad") int cantidad){
        ProductoServices prodServ = CDI.current().select(ProductoServices.class).get();
        try {
            return prodServ.decrementa(id_producto, cantidad);
        } catch (Exception ex) {
            Logger.getLogger(ProductoResources.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
}
