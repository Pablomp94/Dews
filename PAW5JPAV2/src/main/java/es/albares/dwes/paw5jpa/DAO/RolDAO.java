/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5jpa.DAO;

import es.albares.dwes.paw5jpa.database.GestorConexion;
import es.albares.dwes.paw5jpa.entidades.Rol;
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
public class RolDAO implements EntidadDAOBD<Rol, String>{
    
    private static final Logger LOGGER = Logger.getLogger(RolDAO.class.getName());

    @Inject
    private GestorConexion gestorCon;

    @Override
    public List<Rol> getAll() throws SQLException {
        String consulta = "select * from rol;";
        List<Rol> roles = new ArrayList<>();

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    roles.add(new Rol(rs.getString("CODIGO"), rs.getString("NOMBRE")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo getAllAficiones", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniendo getAllAficiones", ex);
            throw ex;
        }
        return roles;
    }

    @Override
    public Rol getById(String id) throws SQLException {
        String consulta = "select * from rol where codigo = ?";
        Rol rol = null;

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    rol = new Rol(rs.getString("CODIGO"), rs.getString("NOMBRE"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniedo provinciaByCodigo", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniedo provinciaByCodigo", ex);
            throw ex;
        }
        return rol;
    }
    
    public List<Rol> getRolesByUsuarioId(Integer id) throws SQLException {
        String consulta = "select rol_codigo from usuario_rol where usuario_id = ?";
        List<Rol> roles = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    roles.add(new Rol(rs.getString("rol_codigo"), this.getById(rs.getString("rol_codigo")).getNombre()));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo getRolesByUsuarioId", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniendo getRolesByUsuarioId", ex);
            throw ex;
        }
        return roles;
    }

    @Override
    public String insert(Rol t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Rol t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Rol t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
