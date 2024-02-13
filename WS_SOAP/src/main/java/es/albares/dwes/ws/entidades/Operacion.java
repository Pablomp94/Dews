/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.ws.entidades;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Pablo
 */
    @XmlRootElement(name = "operacion")
public class Operacion implements Serializable {
 private String operador;
 private int operando1, operando2, resultado;
 private String literal;

 public Operacion() {};

 public Operacion(String oper, int op1, int op2, int result, String literal) {
 this.operador = oper;
 this.operando1 = op1;
 this.operando2 = op2;
 this.resultado = result;
 this.literal = literal;
 }
 // geter y seters por implementar…

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }
 
 
 
 
}

