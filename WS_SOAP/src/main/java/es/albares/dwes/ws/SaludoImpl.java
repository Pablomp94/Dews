package es.albares.dwes.ws;

import jakarta.jws.WebService;

@WebService(endpointInterface = "es.albares.dwes.ws.Saludo")
public class SaludoImpl implements Saludo {

    @Override
    public String saludo(String nombre) {
        return "Hola " + nombre + " !";
    }
}
