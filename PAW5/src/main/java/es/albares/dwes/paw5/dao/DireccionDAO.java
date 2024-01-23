/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.dao;

import es.albares.dwes.paw5.database.GestorConexion;
import es.albares.dwes.paw5.entidades.Direccion;
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
public class DireccionDAO implements EntidadDAOBD<Direccion, String> {

    private static final Logger LOGGER = Logger.getLogger(DireccionDAO.class.getName());
    @Inject
    private GestorConexion gestorCon;

    public DireccionDAO() {
    }

    public List<Direccion> getAll() throws SQLException {
        String consulta = "select codigo, nombre from direccion";
        List<Direccion> direcciones = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = gestorCon.getConnection();
            ptm = conn.prepareStatement(consulta);
            rs = ptm.executeQuery();
            while (rs.next()) {
                direcciones.add(new Direccion (rs.getInt("id"),rs.getInt("idUsuario"),rs.getString("direccion"), rs.getString("localidad"), rs.getString("codigoPostal"), rs.getProvincia("provincia")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando direcciones", ex);
            throw ex;
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando direcciones - rs", ex);
                throw ex;
            }
            try {
                ptm.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando direcciones - ptm", ex);
                throw ex;
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando direcciones - conn", ex);
                throw ex;
            }
        }
        return direcciones;
    }

    public Direccion getById(String codigo) throws SQLException {
        String consulta = "select codigo, nombre from direccion where codigo = ?";
        Direccion direccion = null;

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setString(1, codigo);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    direcciones.add(new Direccion (rs.getInt("id"),rs.getInt("idUsuario"),rs.getString("direccion"), rs.getString("localidad"), rs.getString("codigoPostal"), rs.getProvincia("provincia")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniedo direccionByCodigo", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniedo direccionByCodigo", ex);
            throw ex;
        }
        return direccion;
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

    
}
    