package es.albares.dwes.paw6ws.dao;

import es.albares.dwes.paw6ws.basedatos.GestorConexion;
import es.albares.dwes.paw6ws.entidades.Aficion;
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
public class AficionDAO implements EntidadDaoBD<Aficion, String>{
    
    private static final Logger LOGGER = Logger.getLogger(AficionDAO.class.getName());
    
    @Inject
    private GestorConexion gestorCon;

    public AficionDAO() {
    }
    
    @Override
    public List<Aficion> getAll() throws SQLException {
        
        String consulta = "select nombre from aficion";
        List<Aficion> aficiones = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pts = conn.prepareStatement(consulta);
            ResultSet rs = pts.executeQuery();) {
            while (rs.next()) {
                Aficion aficion = new Aficion(rs.getString("nombre"));
                aficiones.add(aficion);
            }            
            
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando provincias", ex);
            throw ex;
        } 
                
        return aficiones;
    }

    @Override
    public Aficion getById(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    public List<Aficion> getAficionesByUsuarioId(Integer usuarioId) throws SQLException {
        
        String consulta = "select AFICION_NOMBRE from USUARIO_AFICION where usuario_id = ?";
        List<Aficion> aficiones = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pts = conn.prepareStatement(consulta);) {
            pts.setInt(1, usuarioId);
            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                aficiones.add(new Aficion(rs.getString("AFICION_NOMBRE")));
            }            
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando provincias", ex);
            throw ex;
        } 
                
        return aficiones;
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
