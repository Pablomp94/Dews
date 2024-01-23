/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.dao;

import es.albares.dwes.paw5.database.GestorConexion;
import es.albares.dwes.paw5.entidades.Aficion;
import es.albares.dwes.paw5.entidades.Direccion;
import es.albares.dwes.paw5.entidades.Usuario;
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
 * @author Pablo
 */
@ApplicationScoped
public class UsuarioDAO implements EntidadDAOBD<Usuario, String> {

    private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class.getName());
    @Inject
    private GestorConexion gestorCon;

    public UsuarioDAO() {
    }

    public List<Usuario> getAll() throws SQLException {
        String consulta = "select codigo, nombre from usuario";
        List<Usuario> usuarios = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = gestorCon.getConnection();
            ptm = conn.prepareStatement(consulta);
            rs = ptm.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getString("codigo"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error consultando usuarios", ex);
            throw ex;
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando usuarios - rs", ex);
                throw ex;
            }
            try {
                ptm.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando usuarios - ptm", ex);
                throw ex;
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error consultando usuarios - conn", ex);
                throw ex;
            }
        }
        return usuarios;
    }

    public Usuario getById(String codigo) throws SQLException {
        String consulta = "select codigo, nombre from usuario where codigo = ?";
        Usuario usuario = null;

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setString(1, codigo);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    usuario = new Usuario(rs.getString("codigo"), rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error obteniedo usuarioByCodigo", ex);
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error obteniedo usuarioByCodigo", ex);
            throw ex;
        }
        return usuario;
    }

    /**
     *
     * @param usuario
     * @return
     * @throws SQLException
     */
    public Integer insert(Usuario usuario) throws SQLException {
        String insertUsuario = "insert into usuario(nombre, apellidos, sexo, fecha_nacimiento, dni,login, password, email) values( ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)";
        // no requiere id"

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
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error insertando usuario - cierre rs usuario", ex);
                throw ex;
            }
            try {
                pst.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error insertando usuario - cierre pst usuario", ex);
                throw ex;
            }

            if (idUsuario == 0) {
                LOGGER.log(Level.SEVERE, "Error insertando usuario");
                throw new SQLException("Error insertando usuario");
            }

            String insertDireccion = "insert into direccion_usuario(usuario_id, direccion, localidad, provincia, codigo_postal) values( ?,  ?,  ?,  ?,  ?)"; // no requiere id
            // consideramos que solo hay una dirección (por ahora)
            if (usuario.getDirecciones() != null && !usuario.getDirecciones().isEmpty()) {

                // insertamos direccion
                Iterator<Direccion> itDic = usuario.getDirecciones().iterator();
                Direccion dic = itDic.next(); // recuperamos la primera
                pst = conn.prepareStatement(insertDireccion);
                index = 1;
                pst.setInt(index++, idUsuario);
                pst.setString(index++, dic.getDireccion());
                pst.setString(index++, dic.getLocalidad());
                pst.setString(index++, dic.getProvincia().getCodigo());
                pst.setString(index++, dic.getCodigoPostal());
                pst.executeUpdate();

                try {
                    pst.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error insertando usuario - cierre pst direccion", ex);
                    throw ex;
                }
            }

            String insertRol = "insert into usuario_rol(usuario_id, rol_codigo) values (?, ?)"; // por
            //defecto rol "cliente"
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

            String insertAficion = "insert into usuario_aficion(usuario_id, aficion_nombre) values (?, ?)";
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
            try {
                pst.close();
            } catch (SQLException ex) {
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

    public Usuario getUsuarioByLoginPassw(String login, String passw) throws SQLException {

        String consulta = "select id, nombre, apellidos, sexo, fecha_nacimiento, dni, login, email, fecha_registro from usuario where login =  ? and  password =  ?";
 
        Usuario usuario = null;

        try (Connection conn = gestorCon.getConnection(); PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setString(1, login);
            pst.setString(2, passw);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"),
                            rs.getString("apellidos"), rs.getString("sexo"),
                            rs.getDate("fecha_nacimiento"), rs.getString("dni"),
                            rs.getString("login"), null, rs.getString("email"),
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

}
