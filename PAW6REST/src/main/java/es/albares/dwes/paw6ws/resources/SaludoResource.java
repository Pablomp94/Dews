package es.albares.dwes.paw6ws.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/saludo")
public class SaludoResource {

    @GET
    @Path("/{nombre}")
    @Produces(MediaType.TEXT_HTML)
    public String saludo(@PathParam("nombre") String nombre) {
        return "Hola " + nombre + "!";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String saludoNombre(@QueryParam("nombre") String nombre) {
        if (nombre == null) {
            return "Hola!";
        }
        return "Hola " + nombre + "!";
    }
}
