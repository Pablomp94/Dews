/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5jpa.entidades;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public enum Sexo implements Serializable {    

    M("Masculino"),
    F("Femenino"),
    O("Prefiero no decirlo");
    
    private static final long serialVersionUID = 1L;    

    private final String sexo;

    private Sexo(String texto) {
        this.sexo = texto;
    }            

    public String getSexo() {
        return this.sexo;
    }   
}
