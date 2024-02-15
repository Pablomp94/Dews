/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.resources;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author Pablo
 */
@Path("/saludo")
public class SaludoResource {

    @GET
    @Path("/{nombre}")
    @Produces(MediaType.TEXT_HTML)
    public String saludo(@PathParam("nombre") String nombre) {
        return "Hola " + nombre + "!";
    }

}
