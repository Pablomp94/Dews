/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.dao;

import es.albares.dwes.paw5.database.GestorConexion;
import es.albares.dwes.paw5.entidades.Rol;
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
 * @author Pablo
 */
@ApplicationScoped
public class RolDAO implements EntidadDAOBD<Rol, String> {

    private static final Logger LOGGER = Logger.getLogger(RolDAO.class.getName());
    @Inject
    private GestorConexion gestorCon;

    public RolDAO() {
    }

    public List<Rol> getAll() throws SQLException {
        String consulta = "select codigo, nombre from rol";
        List<Rol> rols = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = gestorCon.getConnection();
            ptm = conn.prepareStatement(consulta);
            rs = ptm.executeQuery();
            while (rs.next()) {
                rols.add(new Rol(rs.getString("codigo"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando rols", ex);
            throw ex;
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando rols - rs", ex);
                throw ex;
            }
            try {
                ptm.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando rols - ptm", ex);
                throw ex;
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando rols - conn", ex);
                throw ex;
            }
        }
        return rols;
    }

    public Rol getById(String codigo) throws SQLException {
        String consulta = "select codigo, nombre from rol where codigo = ?";
        Rol rol = null;

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setString(1, codigo);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    rol = new Rol(rs.getString("codigo"), rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniedo rolByCodigo", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniedo rolByCodigo", ex);
            throw ex;
        }
        return rol;
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
    