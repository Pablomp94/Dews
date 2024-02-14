/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albares.dwes.paw5.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("mensajeBean")
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

    public void setMensajeAviso(String mensaje) {
        this.mensaje = mensaje;
        this.estilo = Estilo.AVISO.getStyle();
    }

    public void setMensajeInfo(String mensaje) {
        this.mensaje = mensaje;
        this.estilo = Estilo.INFO.getStyle();
    }

    public void setMensajeError(String mensaje) {
        this.mensaje = mensaje;
        this.estilo = Estilo.ERROR.getStyle();
    }
}
