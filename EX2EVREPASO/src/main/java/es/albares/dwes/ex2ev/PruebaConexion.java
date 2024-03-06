package es.albares.dwes.paw6ws;

import es.albares.dwes.ex2ev.basedatos.GestorConexion;
import jakarta.inject.Inject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/conexion")
public class PruebaConexion extends HttpServlet {
    
    @Inject
    GestorConexion cm;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection con = null;
  
        try {
            con = cm.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                st.execute("SELECT 1 FROM PROVINCIA");
                st.close();
                
                response.getWriter().println("ConnectionManager: OK. ");
            }
        } catch (Exception ex) {
            response.getWriter().println("ConnectionManager: FAIL. " + ex.getMessage());
        } finally {
            if (con != null) try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        response.getWriter().println("Prueba finalizada.");
    }
}
