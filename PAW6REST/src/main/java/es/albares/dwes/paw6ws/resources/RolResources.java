package es.albares.dwes.paw6ws.resources;

import es.albares.dwes.paw6ws.dao.RolDAO;
import es.albares.dwes.paw6ws.entidades.Rol;
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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/rol")
@Produces(MediaType.APPLICATION_JSON)
public class RolResources {

    // Devuelve lista de roles 
    @GET
    public List<Rol> getRoles() {
        RolDAO rolDao = CDI.current().select(RolDAO.class).get();
        try {
            return rolDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(RolResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Path("/{codigo}")    
    // Obtiene Rol por su clave primaria
    public Rol getRolById(@PathParam("codigo") String codigo){
        RolDAO rolDao = CDI.current().select(RolDAO.class).get();
        try {
            return rolDao.getById(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(RolResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // devuelve el codigo del rol
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertRol(Rol rol){
        RolDAO rolDao = CDI.current().select(RolDAO.class).get();
        try {
            return rolDao.insert(rol);
        } catch (SQLException ex) {
            Logger.getLogger(RolResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Devuelve el número de filas insertado (será 1 si es actualizado)
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer updateRol(Rol rol){
        RolDAO rolDao = CDI.current().select(RolDAO.class).get();
        try {
            return rolDao.update(rol);
        } catch (SQLException ex) {
            Logger.getLogger(RolResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    // Devuelve el número de filas borrado (será 1 si es borrado)
    @DELETE
    @Path("/{codigo}")
    public Integer deleteRol(@PathParam("codigo") String codigo){
        RolDAO rolDao = CDI.current().select(RolDAO.class).get();
        try {
            return rolDao.deleteByCodigo(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(RolResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
