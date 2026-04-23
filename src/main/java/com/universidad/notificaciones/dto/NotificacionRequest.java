package com.universidad.notificaciones.dto;

import com.universidad.notificaciones.model.enums.TipoNotificacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NotificacionRequest {

    @NotBlank(message = "El código es obligatorio.")
    private String codigo;

    @NotBlank(message = "El mensaje es obligatorio.")
    private String mensaje;

    @NotNull(message = "El tipo de notificación es obligatorio.")
    private TipoNotificacion tipo;

    @NotNull(message = "El id del destinatario es obligatorio.")
    private Long destinatarioId;

    @NotNull(message = "El id del canal es obligatorio.")
    private Long canalId;

    public NotificacionRequest() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotificacion tipo) {
        this.tipo = tipo;
    }

    public Long getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Long destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public Long getCanalId() {
        return canalId;
    }

    public void setCanalId(Long canalId) {
        this.canalId = canalId;
    }
}