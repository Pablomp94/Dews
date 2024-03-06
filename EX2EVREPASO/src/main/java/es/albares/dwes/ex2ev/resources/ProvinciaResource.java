/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.ex2ev.resources;

import es.albares.dwes.ex2ev.entidades.Provincia;
import es.albares.dwes.ex2ev.repositorios.ProvinciaRepositorio;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/provincia")
public class ProvinciaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Provincia> getProvincias() {
        ProvinciaRepositorio provinciaRepo = CDI.current()
                .select(ProvinciaRepositorio.class).get();
        return provinciaRepo.getProvincias();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Provincia getProvinciaById(@PathParam("codigo") String codigo) {
        ProvinciaRepositorio provinciaRepo = CDI.current()
                .select(ProvinciaRepositorio.class).get();
        return provinciaRepo.getProvinciaById(codigo);
    }
}
