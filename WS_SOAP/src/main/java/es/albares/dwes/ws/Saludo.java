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
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService
public interface Saludo {

    @WebMethod(operationName = "saludo")
    public String saludo(@WebParam(name = "nombre") String nombre);
}
