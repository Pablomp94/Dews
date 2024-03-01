package es.albares.dwes.paw6ws.resources;

import es.albares.dwes.paw6ws.entidades.Rol;
import java.util.List;

public interface IRolResources {
    
    // Devuelve lista de roles 
    public List<Rol> getRoles(); 
    
    // Otiene Rol por su clave primaria
    public Rol getRolById(String codigo);
            
    // devuelve el codigo del rol
    public String insertRol(Rol rol);
   
    // Devuelve el número de filas insertado (será 1 si es actualizado)
    public int updateRol(Rol rol);
    
    // Devuelve el número de filas borrado (será 1 si es borrado)
    public int deleteRol(String codigo);
}
