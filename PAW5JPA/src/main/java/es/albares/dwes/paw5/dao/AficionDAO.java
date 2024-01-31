/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.dao;

import es.albares.dwes.paw5.database.GestorConexion;
import es.albares.dwes.paw5.entidades.Aficion;
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
public class AficionDAO implements EntidadDAOBD<Aficion, String> {

    private static final Logger LOGGER = Logger.getLogger(AficionDAO.class.getName());
    @Inject
    private GestorConexion gestorCon;

    public AficionDAO() {
    }

    public List<Aficion> getAll() throws SQLException {
        String consulta = "select codigo, nombre from aficion";
        List<Aficion> aficiones = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = gestorCon.getConnection();
            ptm = conn.prepareStatement(consulta);
            rs = ptm.executeQuery();
            while (rs.next()) {
                aficiones.add(new Aficion( rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando aficiones", ex);
            throw ex;
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando aficiones - rs", ex);
                throw ex;
            }
            try {
                ptm.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando aficiones - ptm", ex);
                throw ex;
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando aficiones - conn", ex);
                throw ex;
            }
        }
        return aficiones;
    }

    public Aficion getById(String codigo) throws SQLException {
        String consulta = "select codigo, nombre from aficion where codigo = ?";
        Aficion aficion = null;

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setString(1, codigo);
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
    