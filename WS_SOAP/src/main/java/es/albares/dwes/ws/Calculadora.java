/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.ws;

import es.albares.dwes.ws.entidades.Operacion;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author Pablo
 */


    @WebService(serviceName = "calculadora")
    public class Calculadora {

        @WebMethod(operationName = "add")
        public Operacion add(@WebParam(name = "op1") int op1, @WebParam(name = "op2") int op2) {
            return new Operacion("add", op1, op2, op1 + op2, op1 + " + " + op2 + " = " + (op1 + op2));
        }

        @WebMethod(operationName = "subtract")
        public Operacion subtract(@WebParam(name = "op1") int op1, @WebParam(name = "op2") int op2) {
            return new Operacion("subtrac", op1, op2, op1 - op2, op1 + " - " + op2 + " = " + (op1 - op2));
        }
    }


