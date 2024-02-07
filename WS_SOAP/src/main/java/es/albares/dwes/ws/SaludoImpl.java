/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pablo
 */
package es.albares.dwes.ws;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.albares.dwes.ws.Saludo")
public class SaludoImpl implements Saludo {

    @Override
    public String saludo(String nombre) {
        return "Hola " + nombre + " !";
    }
}
