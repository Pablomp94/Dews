/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package es.albares.dwes.paw3.filtros;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author usuario
 */
@WebFilter(filterName = "ConfigFilter", urlPatterns = {"/*"})
public class ConfigFilter implements Filter {
    
    public static final String CookieConfigTema = "configuracionTema";
    
    public ConfigFilter() {
    }    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
                
        HttpServletRequest peticion = (HttpServletRequest) request;
        
        Cookie[] cookies = peticion.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (CookieConfigTema.equals(ck.getName())) {
                    peticion.setAttribute(CookieConfigTema, ck.getValue());
                }
            }
        }
        
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
}
