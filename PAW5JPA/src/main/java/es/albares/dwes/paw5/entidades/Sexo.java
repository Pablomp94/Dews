/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.entidades;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public enum Sexo implements Serializable{
    
    M("Masculino"),
    F("Femenino"),
    O("Prefiero no decirlo");
    
    private final String sexo;
    
    private Sexo(String sexo){
        this.sexo = sexo;
    }
    
    private String getSexo(){
        return sexo;
    }
    
}
