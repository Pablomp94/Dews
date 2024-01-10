/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
@WebServlet("/pruebaconexion")
public class pruebaConexion extends HttpServlet {

    @Inject
    GestorConexion cm;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection con = null;

        try {
            con = cm.getConnection();
            if (con != null) {
                try (Statement st = con.createStatement()) {
                    st.execute("SELECT 1 FROM PROVINCIA");
                }

                response.getWriter().println("Conexión: OK. ");
            }
        } catch (IOException | SQLException ex) {
            response.getWriter().println("Conexión: ERROR. " + ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(pruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.getWriter().println("Prueba finalizada.");
    }
}
