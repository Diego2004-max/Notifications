package com.universidad.notificaciones.model.entity;

import com.universidad.notificaciones.exception.BusinessException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "canales_push")
public class CanalPush extends CanalNotificacion {

    @Column(nullable = false)
    private String aplicacion;

    @Column(nullable = false)
    private String prioridad;

    public CanalPush() {
    }

    public CanalPush(String aplicacion, String prioridad) {
        this.aplicacion = aplicacion;
        this.prioridad = prioridad;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        String token = notificacion.getDestinatario().getTokenDispositivo();

        if (token == null || token.isBlank()) {
            throw new BusinessException("El usuario no tiene token de dispositivo registrado.");
        }

        System.out.println("=== ENVIO PUSH ===");
        System.out.println("Aplicación: " + aplicacion);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Token dispositivo: " + token);
        System.out.println("Mensaje: " + notificacion.getMensaje());
    }
}