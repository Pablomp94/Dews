package es.albares.dwes.paw5.entidades;

import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;

/**
 *
 * @author usuario
 */
@RequestScoped
public class MensajeBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String mensaje;
    private String estilo;
    
    public enum Estilo {        
        AVISO("avisoMensaje"),
        INFO("infoMensaje"),
        ERROR("errorMensaje");
        
        private final String style;
        
        private Estilo(String style) {
            this.style = style;
        }
        
        public String getStyle() {
            return style;
        }   
    }

    public MensajeBean() {
    }

    public MensajeBean(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
