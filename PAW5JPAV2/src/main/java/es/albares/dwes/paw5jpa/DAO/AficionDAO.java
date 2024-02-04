/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5jpa.DAO;

import es.albares.dwes.paw5jpa.database.GestorConexion;
import es.albares.dwes.paw5jpa.entidades.Aficion;
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
public class AficionDAO implements EntidadDAOBD<Aficion, String> {

    private static final Logger LOGGER = Logger.getLogger(AficionDAO.class.getName());

    @Inject
    private GestorConexion gestorCon;

    @Override
    public List<Aficion> getAll() throws SQLException {
        String consulta = "select * from aficion";
        List<Aficion> aficiones = new ArrayList<>();

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    aficiones.add(new Aficion(rs.getString("nombre")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo getAllAficiones", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniendo getAllAficiones", ex);
            throw ex;
        }
        return aficiones;
    }
    
    public List<Aficion> getAficionesByUsuarioId(Integer id) throws SQLException{
        String consulta = "select * from usuario_aficion where usuario_id = ?";
        List<Aficion> aficiones = new ArrayList<>();

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    aficiones.add(new Aficion(rs.getString("aficion_nombre")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo getAficionesByUsuarioId", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniendo getAficionesByUsuarioId", ex);
            throw ex;
        }
        return aficiones;
    }

    @Override
    public Aficion getById(String id) throws SQLException {
        String consulta = "select * from aficion where nombre = ?";
        Aficion aficion = null;

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    aficion = new Aficion(rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniedo aficionByCodigo", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniedo aficionByCodigo", ex);
            throw ex;
        }
        return aficion;
    }

    @Override
    public String insert(Aficion t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Aficion t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Aficion t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
