/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.dao;

import es.albares.dwes.paw5.database.GestorConexion;
import es.albares.dwes.paw5.entidades.Provincia;
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
public class ProvinciaDAO implements EntidadDAOBD<Provincia, String> {

    private static final Logger LOGGER = Logger.getLogger(ProvinciaDAO.class.getName());
    @Inject
    private GestorConexion gestorCon;

    public ProvinciaDAO() {
    }

    @Override
    public List<Provincia> getAll() throws SQLException {
        String consulta = "select codigo, nombre from provincia";
        List<Provincia> provincias = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = gestorCon.getConnection();
            ptm = conn.prepareStatement(consulta);
            rs = ptm.executeQuery();
            while (rs.next()) {
                provincias.add(new Provincia(rs.getString("codigo"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando provincias", ex);
            throw ex;
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando provincias - rs", ex);
                throw ex;
            }
            try {
                ptm.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando provincias - ptm", ex);
                throw ex;
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando provincias - conn", ex);
                throw ex;
            }
        }
        return provincias;
    }

    @Override
    public Provincia getById(String codigo) throws SQLException {
        String consulta = "select codigo, nombre from provincia where codigo = ?";
        Provincia provincia = null;

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setString(1, codigo);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    provincia = new Provincia(rs.getString("codigo"), rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniedo provinciaByCodigo", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniedo provinciaByCodigo", ex);
            throw ex;
        }
        return provincia;
    }

    @Override
    public String insert(Provincia t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Provincia t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Provincia t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    