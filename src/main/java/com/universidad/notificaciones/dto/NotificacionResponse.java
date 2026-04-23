package com.universidad.notificaciones.dto;

import com.universidad.notificaciones.model.enums.EstadoNotificacion;
import com.universidad.notificaciones.model.enums.TipoNotificacion;

import java.time.LocalDateTime;

public class NotificacionResponse {

    private Long id;
    private String codigo;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private EstadoNotificacion estado;
    private TipoNotificacion tipo;
    private Long destinatarioId;
    private String destinatarioNombre;
    private Long canalId;
    private String tipoCanal;

    public NotificacionResponse() {
    }

    public NotificacionResponse(Long id, String codigo, String mensaje, LocalDateTime fechaEnvio,
                                EstadoNotificacion estado, TipoNotificacion tipo,
                                Long destinatarioId, String destinatarioNombre,
                                Long canalId, String tipoCanal) {
        this.id = id;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.tipo = tipo;
        this.destinatarioId = destinatarioId;
        this.destinatarioNombre = destinatarioNombre;
        this.canalId = canalId;
        this.tipoCanal = tipoCanal;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public EstadoNotificacion getEstado() {
        return estado;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public Long getDestinatarioId() {
        return destinatarioId;
    }

    public String getDestinatarioNombre() {
        return destinatarioNombre;
    }

    public Long getCanalId() {
        return canalId;
    }

    public String getTipoCanal() {
        return tipoCanal;
    }
}