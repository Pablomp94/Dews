package es.albares.dwes.paw5jpa.basedatos;

import jakarta.enterprise.context.ApplicationScoped;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author usuario
 */
@ApplicationScoped
public class GestorConexion {

    private static final Logger LOGGER = Logger.getLogger(GestorConexion.class.getName());
    
    private DataSource dataSource;
    
    /**
     * Inicializa el DataSource 
     */
    public void initDS() {
        try {
            // Obtiene el DataSource
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/tiendaBD");
        } catch (NamingException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener el DataSource: ".concat(e.getMessage()));
            throw new RuntimeException("Error al obtener el DataSource");
        }
    }

    /**
     * Devuelve un conexión de la BD (pool de conexiones)
     * @return conexion a la BD
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "No se ha podido obtener conexión: ".concat(e.getMessage()));
            throw e;
        }
        if (connection == null) {
            throw new RuntimeException("Conexión nula");
        }
        return connection;
    }
}
