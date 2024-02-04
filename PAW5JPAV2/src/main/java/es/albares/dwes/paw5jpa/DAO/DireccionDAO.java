/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5jpa.DAO;

import es.albares.dwes.paw5jpa.database.GestorConexion;
import es.albares.dwes.paw5jpa.entidades.Direccion;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eloy
 */
@ApplicationScoped
public class DireccionDAO implements EntidadDAOBD<Direccion, String> {

    private static final Logger LOGGER = Logger.getLogger(AficionDAO.class.getName());

    @Inject
    private GestorConexion gestorCon;
    
    @Inject
    private ProvinciaDAO provinciaDAO;

    @Override
    public List<Direccion> getAll() throws SQLException {
        String consulta = "select * from direccion_usuario";
        List<Direccion> direcciones = new ArrayList<>();
        

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    direcciones.add(new Direccion(
                            rs.getInt("id"), rs.getString("direccion"),
                            rs.getString("localidad"), 
                            provinciaDAO.getById(rs.getString("provincia")),
                            rs.getString("codigo_postal")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo getAllAficiones", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniendo getAllAficiones", ex);
            throw ex;
        }
        return direcciones;
    }
    
    @Override
    public String insert(Direccion t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Direccion t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Direccion t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Direccion> getDirecionesByUsuarioId(Integer id) throws SQLException {
        String consulta = "select * from direccion_usuario where usuario_id = ?";
        List<Direccion> direcciones = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    direcciones.add(new Direccion(
                            rs.getInt("id"), rs.getString("direccion"),
                            rs.getString("localidad"), 
                            provinciaDAO.getById(rs.getString("provincia")),
                            rs.getString("codigo_postal")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo getDirecionesByUsuario", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniendo getDirecionesByUsuario", ex);
            throw ex;
        }
        return direcciones;
    }

    @Override
    public Direccion getById(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
