package es.albares.dwes.paw4;

import jakarta.annotation.security.DeclareRoles;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/protegido")
@DeclareRoles({"admin"})
@ServletSecurity(@HttpConstraint(rolesAllowed = "admin"))
public class ServletProtegido extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getUserPrincipal() != null) {
            response.getWriter().println("Usuario: " + request.getUserPrincipal().getName());
        }
        
        response.getWriter().println("Usuario con rol \"admin\"? " + request.isUserInRole("admin"));
    }
}
