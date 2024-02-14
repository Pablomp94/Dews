/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5jpa.resources;

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
