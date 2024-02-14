package es.albares.dwes.paw5jpa.dao;

import es.albares.dwes.paw5jpa.basedatos.GestorConexion;
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
 * @author usuario
 */
@ApplicationScoped
public class DireccionDAO implements EntidadDaoBD<Direccion, Integer> {
    
    private static final Logger LOGGER = Logger.getLogger(DireccionDAO.class.getName());
    
    @Inject
    private GestorConexion gestorCon;
    
    @Inject
    ProvinciaDAO provinciaDAO;

    public DireccionDAO() {
    }
    
    @Override
    public List<Direccion> getAll() throws SQLException {
        String consulta = "select id, usuario_id, direccion, localidad, provincia, codigoPostal from direccion_usuario"; 
        List<Direccion> direcciones = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();) {
            while (rs.next()) {
                direcciones.add(new Direccion(rs.getInt("id"), rs.getInt("usuario_id"), rs.getString("direccion"), rs.getString("localidad"), 
                        rs.getString("codigo_postal"), provinciaDAO.getById(rs.getString("provincia"))));
            }            
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando direcciones", ex);
            throw ex;
        } 
        return direcciones;
    }
    
    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Direccion getById(Integer id) throws SQLException {
        
        String consulta = "select id, usuario_id, direccion, localidad, provincia, codigo_postal from direccion_usuario where id = ?";
        Direccion direccion = null;
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pst = conn.prepareStatement(consulta);){
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    direccion = new Direccion(rs.getInt("id"), rs.getInt("usuario_id"), rs.getString("direccion"), rs.getString("localidad"), 
                        rs.getString("codigo_postal"), provinciaDAO.getById(rs.getString("provincia")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo byId - rs", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniendo byId", ex);
            throw ex;
        } 
        return direccion;
    }    
    
    public List<Direccion> getDirecionesByUsuario(Integer idUsuario) throws SQLException {
        
        String consulta = "select id, usuario_id, direccion, localidad, provincia, codigo_postal from direccion_usuario where usuario_id = ?";
        List<Direccion> direcciones = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pst = conn.prepareStatement(consulta);){
            pst.setInt(1, idUsuario);
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    direcciones.add(
                            new Direccion(rs.getInt("id"), rs.getInt("usuario_id"), rs.getString("direccion"), rs.getString("localidad"), 
                        rs.getString("codigo_postal"), provinciaDAO.getById(rs.getString("provincia"))));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo getDirecionesByUsuario - rs", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniendo getDirecionesByUsuario", ex);
            throw ex;
        } 
        return direcciones;
    }
    
    @Override
    public Integer insert(Direccion direccion) throws SQLException {
        String insertDireccion = "insert into direccion_usuario(usuario_id, direccion, localidad, provincia, codigo_postal) values (?, ?, ?, ?, ?)"; // no requiere id
        
        // comprobamos si el usuario tiene id, en cuyo caso no se inserta
        if (direccion.getId() != null) {
            LOGGER.log(Level.SEVERE, "Error insertando Direccion - direcion ya insertada");
            throw new SQLException("Error insertando Direccion - dirección ya está insertado");
        }
        
        int idDireccion = 0;
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pst = conn.prepareStatement(insertDireccion, PreparedStatement.RETURN_GENERATED_KEYS);) {
            int index = 1;
            pst.setInt(index++, direccion.getUsuarioId());
            if (direccion.getDireccion() != null) {
                pst.setString(index++, direccion.getDireccion());
            } else {
                pst.setNull(index++, java.sql.Types.VARCHAR);
            }
            if (direccion.getLocalidad() != null) {
                pst.setString(index++, direccion.getLocalidad());
            } else {
                pst.setNull(index++, java.sql.Types.VARCHAR);
            }
            if (direccion.getProvincia() != null) {
                pst.setString(index++, direccion.getProvincia().getCodigo());
            } else {
                pst.setNull(index++, java.sql.Types.VARCHAR);
            }
            if (direccion.getCodigoPostal() != null) {
                pst.setString(index++, direccion.getCodigoPostal());
            } else {
                pst.setNull(index++, java.sql.Types.VARCHAR);
            } 
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys(); // devuelve los ids generados
            if (rs.next()) {
                idDireccion = rs.getInt(1);
            }
            try { rs.close(); } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error insertando dirección - cierre rs", ex);
                throw ex;
            }        
            
            if (idDireccion == 0) {
                LOGGER.log(Level.SEVERE, "Error insertando dirección");
                throw new SQLException("Error insertando dirección");
            }
        }
        return idDireccion;
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
