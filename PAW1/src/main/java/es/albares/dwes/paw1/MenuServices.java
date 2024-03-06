package es.albares.dwes.paw1;

import java.util.ArrayList;
import java.util.List;

public class MenuServices {
    
    public List<EnlaceHTML> getMenu() {

        List<EnlaceHTML> lstEnlaces = new ArrayList<>();

        lstEnlaces.add(new EnlaceHTML("Inicio", "inicio"));
        lstEnlaces.add(new EnlaceHTML("Productos", "productos"));
        lstEnlaces.add(new EnlaceHTML("Servicios", "servicios"));
        lstEnlaces.add(new EnlaceHTML("Contacto", "contacto"));
        
        return lstEnlaces;
        
    }
}
