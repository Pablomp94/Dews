package es.albares.dwes.paw5.servicios;

import es.albares.dwes.paw5.dao.AficionDAO;
import es.albares.dwes.paw5.dao.DireccionDAO;
import es.albares.dwes.paw5.dao.ProvinciaDAO;
import es.albares.dwes.paw5.dao.RolDAO;
import es.albares.dwes.paw5.dao.UsuarioDAO;
import es.albares.dwes.paw5.entidades.Aficion;
import es.albares.dwes.paw5.entidades.Direccion;
import es.albares.dwes.paw5.entidades.Sexo;
import es.albares.dwes.paw5.entidades.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author usuario
 */
@ApplicationScoped
public class UsuarioServices {
    
    @Inject
    UsuarioDAO usuarioDAO;
    
    @Inject
    DireccionDAO direccionDAO;
    
    @Inject
    ProvinciaDAO provinciaDAO;
    
    @Inject
    AficionDAO aficDAO;
    
    @Inject
    RolDAO rolDAO;
    
    public Usuario registraUsuario(String nombre, String apellidos, String dni, 
            String direccion, String localidad, String codigoPostal, String provincia, 
            String sexo, String[] aficiones, String fechaNacimiento, 
            String login, String passw, String passw_rep, String email) throws Exception {
        
        Usuario usuario = new Usuario();
        try {
            // realizamos las comprobaciones de los datos que se recuperan
            // primero los obligatorios
            if (nombre != null && !nombre.isBlank()) {
                usuario.setNombre(nombre);
            } else {
                throw new Exception("Nombre es obligatorio");
            }
            if (apellidos != null && !apellidos.isBlank()) {
                usuario.setApellidos(apellidos);
            } else {
                throw new Exception("Apellidos es obligatorio");
            }
            if (dni != null && !dni.isBlank()) {
                usuario.setDni(dni);
            } else {
                throw new Exception("DNI es obligatorio");
            }
            
            // login, passw y email
            if (login != null && !login.isBlank()) {
                usuario.setLogin(login);
            } else {
                throw new Exception("Login obligatorio");
            }
            if (passw != null && !passw.isBlank()) {
                if (passw.equals(passw_rep)) {
                    usuario.setPassword(passw);
                } else {
                    throw new Exception("Passwords no coinciden");
                }
            } else {
                throw new Exception("Password obligatorio");
            }
            if (email != null && !email.isBlank()) {
                usuario.setEmail(email);
            } else {
                throw new Exception("Email obligatorio");
            }
            
            if (sexo != null && !sexo.isBlank()) {
                Sexo eSexo = null;
                try {
                    eSexo = Sexo.valueOf(sexo);
                } catch (Exception ex) {
                    throw new Exception("El valor de sexo no es correcto." + ex.getMessage());
                }
                if (eSexo != null) {
                    usuario.setSexo(eSexo);
                } else {
                    throw new Exception("El valor de sexo no es correcto.");
                }
            } else {
                    throw new Exception("El valor de sexo es obligatorio.");
            }

            if (aficiones != null) {
                usuario.setAficiones(Stream.of(aficiones).map(Aficion::new).collect(Collectors.toList()));
            }

            if (fechaNacimiento != null && !fechaNacimiento.isBlank()) {
                SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    usuario.setFechaNacimiento(sdfIn.parse(fechaNacimiento));
                } catch (ParseException ex){
                    throw new Exception("El valor de la fecha de nacimiento no es correcto. " + ex.getMessage());
                }
            }

            // Creamos direccion
            Direccion direc = new Direccion();

            if (direccion != null && !direccion.isBlank()) {
                direc.setDireccion(direccion);
            } 

            if (localidad != null && !localidad.isBlank()) {
                direc.setLocalidad(localidad);
            } 

            // TODO faltaría comprobar la provincia
            if (provincia != null && !provincia.isBlank()) {
                direc.setProvincia(provinciaDAO.getById(provincia));
            } 

            if (codigoPostal != null && !codigoPostal.isBlank()) {
                // Comprobamos que CP tiene el formato esperado
                if (codigoPostal.matches("[0-9]{5}")) {
                    direc.setCodigoPostal(codigoPostal);
                } else {
                    throw new Exception("El codigo postal no tiene el formato esperado {NNNNN}");
                }
            } else {
                    throw new Exception("El codigo postal es obligatorio");
                }

             /* ALMACENAMOS EN BD */ 
             List<Direccion> lstDir = new ArrayList<>();
             lstDir.add(direc);
             usuario.setDirecciones(lstDir);

             // comprobamos que las aficiones asignadas desde el formulario coinciden con alguna de las aficiones de BD (si no coincide no se inserta en la lista del usuario)
             // antes hay que definir el método "equals" en la clase Aficion para asegurar que el ".contains" funcionará correctamente
             List<Aficion> lstAfic = new ArrayList<>();
             if (usuario.getAficiones() != null && !usuario.getAficiones().isEmpty()) {
                 List<Aficion> aficionesBD = aficDAO.getAll();
                 for (Aficion afic : usuario.getAficiones()) {
                     if (aficionesBD.contains(afic)) {
                         lstAfic.add(afic);
                     }
                 }
             }         
             usuario.setAficiones(lstAfic);
             // el rol se le inserta por defecto en el DAO

             usuario.setId(usuarioDAO.insert(usuario));
             return usuario;
        } catch (Exception ex) {
            throw ex;
        }
    }  
    
    public Usuario obtenerUsuario(String login, String passw) throws Exception {
        Usuario usuario = null;
        try {
            usuario = usuarioDAO.getUsuarioByLoginPassw(login, passw);
            if (usuario == null || !usuario.esValido()) {
                throw new Exception("Usuario no encontrado");
            }
            usuario.setDirecciones(direccionDAO.getDirecionesByUsuario(usuario.getId()));
            usuario.setAficiones(aficDAO.getAficionesByUsuarioId(usuario.getId()));
            usuario.setRoles(rolDAO.getRolesByUsuarioId(usuario.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServices.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return usuario;
    }

    public boolean existeUsuario(int idUsuario) {
        Usuario usuario;
        try {
             usuario = usuarioDAO.getById(idUsuario);
        } catch (Exception ex) {
            return false;
        }
        return (usuario != null && usuario.esValido());
    }
    
}
