package es.albares.dwes.paw5.dao;

import es.albares.dwes.paw5.basedatos.GestorConexion;
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
 * @author usuario
 */
@ApplicationScoped
public class RolDAO implements EntidadDaoBD<Rol, String>{
    
    private static final Logger LOGGER = Logger.getLogger(RolDAO.class.getName());
    
    @Inject
    private GestorConexion gestorCon;

    public RolDAO() {
    }
    
    @Override
    public List<Rol> getAll() throws SQLException {
        
        String consulta = "select codigo, nombre from rol";
        List<Rol> roles = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement ptm = conn.prepareStatement(consulta);
            ResultSet rs = ptm.executeQuery();) {
            while (rs.next()) {
                Rol rol = new Rol(rs.getString("codigo"), rs.getString("nombre"));
                roles.add(rol);
            }            
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando roles", ex);
            throw ex;
        }                 
        return roles;
    }
    
    @Override
    public Rol getById(String codigo) throws SQLException {
        
        String consulta = "select codigo, nombre from rol where codigo = ?";
        Rol rol = null;
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = gestorCon.getConnection();
            pst = conn.prepareStatement(consulta);
            pst.setString(1, codigo);
            rs = pst.executeQuery();
            if (rs.next()) {
                rol = new Rol(rs.getString("codigo"), rs.getString("nombre"));
            }            
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando roles", ex);
            throw ex;
        } finally {
            try { rs.close(); } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando roles - cierre rs", ex);
                throw ex;
            }
            try { pst.close(); } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando roles - cierre ptm", ex);
                throw ex;
            }
            try { conn.close(); } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando roles - cierre conn", ex);
                throw ex;
            }
        }
        return rol;
    }
    
    public List<Rol> getRolesByUsuarioId(Integer usuarioId) throws SQLException {
        
        String consulta = "select r.codigo, r.nombre from ROL r join USUARIO_ROL ur on ur.rol_codigo = r.codigo and ur.usuario_id = ?";
        List<Rol> aficiones = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pts = conn.prepareStatement(consulta);) {
            pts.setInt(1, usuarioId);
            try (ResultSet rs = pts.executeQuery()) {
                while (rs.next()) {
                    aficiones.add(new Rol(rs.getString("nombre"), rs.getString("codigo")));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando provincias", ex);
            throw ex;
        } 
                
        return aficiones;
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
