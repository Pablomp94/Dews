/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.ex2ev.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author usuario
 * @param <T>
 * @param <PK>
 */
public interface EntidadDaoBD <T, PK extends Serializable> {
    
    List<T> getAll() throws SQLException;
    
    T getById(PK id) throws SQLException;
        
    PK insert(T t) throws SQLException;
    
    int update(T t) throws SQLException;
    
    int delete(T t) throws SQLException;
}