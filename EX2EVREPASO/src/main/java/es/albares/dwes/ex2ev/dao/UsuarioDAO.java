package es.albares.dwes.ex2ev.dao;

import es.albares.dwes.ex2ev.basedatos.GestorConexion;
import es.albares.dwes.ex2ev.entidades.Aficion;
import es.albares.dwes.ex2ev.entidades.Direccion;
import es.albares.dwes.ex2ev.entidades.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
@ApplicationScoped
public class UsuarioDAO implements EntidadDaoBD<Usuario, Integer> {
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class.getName());
    
    @Inject
    private GestorConexion gestorCon;

    public UsuarioDAO() {
    }
    
    @Override
    public List<Usuario> getAll() throws SQLException {
        String consulta = "select id, nombre, apellidos, sexo, fecha_nacimiento, dni, login, email, fecha_registro from usuario"; // no recupera password
        List<Usuario> usuarios = new ArrayList<>();
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();) {
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("sexo"), 
                        rs.getDate("fecha_nacimiento"), rs.getString("dni"), rs.getString("login"), null, rs.getString("email"), 
                        rs.getDate("fecha_registro"));
                usuarios.add(usuario);
            }            
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando usuarios", ex);
            throw ex;
        } 
        return usuarios;
    }
    
    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Usuario getById(Integer id) throws SQLException {
        
        String consulta = "select id, nombre, apellidos, sexo, fecha_nacimiento, dni, login, email, fecha_registro from usuario where id = ?";
        Usuario usuario = null;
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pst = conn.prepareStatement(consulta);){
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("sexo"), 
                        rs.getDate("fecha_nacimiento"), rs.getString("dni"), rs.getString("login"), null, rs.getString("email"), 
                        rs.getDate("fecha_registro"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo byId - rs", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniedo byId", ex);
            throw ex;
        } 
        return usuario;
    }    
    
    public Usuario getUsuarioByLoginPassw(String login, String passw) throws SQLException {
        
        String consulta = "select id, nombre, apellidos, sexo, fecha_nacimiento, dni, login, email, fecha_registro from usuario where login = ? and password = ?";
        Usuario usuario = null;
        
        try (Connection conn = gestorCon.getConnection();
            PreparedStatement pst = conn.prepareStatement(consulta);){
            pst.setString(1, login);
            pst.setString(2, passw);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("sexo"), 
                        rs.getDate("fecha_nacimiento"), rs.getString("dni"), rs.getString("login"), null, rs.getString("email"), 
                        rs.getDate("fecha_registro"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniendo usuarioByLoginPassw - rs", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniedo usuarioByLoginPassw", ex);
            throw ex;
        } 
        return usuario;
    }
    
    @Override
    public Integer insert(Usuario usuario) throws SQLException {
        String insertUsuario = "insert into usuario(nombre, apellidos, sexo, fecha_nacimiento, dni, login, password, email) values (?, ?, ?, ?, ?, ?, ?, ?)"; // no requiere id
        String insertDireccion = "insert into direccion_usuario(usuario_id, direccion, localidad, provincia, codigo_postal) values (?, ?, ?, ?, ?)"; // no requiere id
        String insertRol = "insert into usuario_rol(usuario_id, rol_codigo) values (?, ?)"; // por defecto rol "cliente"
        String insertAficion = "insert into usuario_aficion(usuario_id, aficion_nombre) values (?, ?)"; 
        
        // comprobamos si el usuario tiene id, en cuyo caso no se inserta
        if (usuario.getId() != null) {
            LOGGER.log(Level.SEVERE, "Error insertando usuario - el usuario ya está insertado");
            throw new SQLException("Error insertando usuario - el usuario ya está insertado");
        }
        
        Connection conn = null;
        PreparedStatement pst = null;
        int idUsuario = 0;
        try {
            conn = gestorCon.getConnection();
            conn.setAutoCommit(false);            
            pst = conn.prepareStatement(insertUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            int index = 1;
            pst.setString(index++, usuario.getNombre());
            pst.setString(index++, usuario.getApellidos());
            pst.setString(index++, usuario.getSexo().name());
            if (usuario.getFechaNacimiento() != null) {
                pst.setDate(index++, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            } else {
                pst.setNull(index++, java.sql.Types.DATE);
            }
            pst.setString(index++, usuario.getDni());
            pst.setString(index++, usuario.getLogin());
            pst.setString(index++, usuario.getPassword());
            pst.setString(index++, usuario.getEmail());   
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys(); // devuelve los ids generados
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }
            try { rs.close(); } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error insertando usuario - cierre rs usuario", ex);
                throw ex;
            }
            try { pst.close(); } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error insertando usuario - cierre pst usuario", ex);
                throw ex;
            }            
            
            if (idUsuario == 0) {
                LOGGER.log(Level.SEVERE, "Error insertando usuario");
                throw new SQLException("Error insertando usuario");
            }
            
            // consideramos que solo hay una dirección (por ahora)
            if (usuario.getDirecciones() != null && !usuario.getDirecciones().isEmpty()) {
            
                // insertamos direccion
                Iterator<Direccion> itDic = usuario.getDirecciones().iterator();
                Direccion dic = itDic.next();
                pst = conn.prepareStatement(insertDireccion);
                index = 1;
                pst.setInt(index++, idUsuario);
                pst.setString(index++, dic.getDireccion());
                pst.setString(index++, dic.getLocalidad());
                pst.setString(index++, dic.getProvincia().getCodigo());
                pst.setString(index++, dic.getCodigoPostal());
                pst.executeUpdate();
                
                try { pst.close(); } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error insertando usuario - cierre pst direccion", ex);
                    throw ex;
                }   
            }
                
            // insertamos rol (por defecto "cliente")
            pst = conn.prepareStatement(insertRol);
            index = 1;
            pst.setInt(index++, idUsuario);
            pst.setString(index++, "cliente");
            pst.executeUpdate();

            try {
                pst.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error insertando usuario - cierre pst rol", ex);
                throw ex;
            }
                
            // insertamos aficiones
            if (usuario.getAficiones() != null && !usuario.getAficiones().isEmpty()) {
                pst = conn.prepareStatement(insertAficion);
                for (Aficion afic : usuario.getAficiones()) {
                    index = 1;
                    pst.setInt(index++, idUsuario);
                    pst.setString(index++, afic.getNombre());
                    pst.addBatch();
                }
                pst.executeBatch();
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error insertando usuarios", ex);
            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
            throw ex;
        } finally {
            try { pst.close(); } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando usuarios - cierre stmt", ex);
                throw ex;
            }
            try {
                conn.commit();
                conn.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando usuarios - commit y close conn", ex);
                throw ex;
            }
        }

        return idUsuario;
    }
    
    @Override
    public int update(Usuario t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Usuario t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
