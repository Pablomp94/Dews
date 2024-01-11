/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albares.dwes.paw5;

import es.albares.dwes.paw5.database.GestorConexion;
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

/**
 *
 * @author eloy
 */
@WebServlet(name = "PruebaConexion", urlPatterns = {"/pruebaconexion"})
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

                response.getWriter().println("Conexión: OK. ");
            }
        } catch (Exception ex) {
            response.getWriter().println("Conexión: ERROR. " + ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.getWriter().println("Prueba finalizada.");
    }
}
