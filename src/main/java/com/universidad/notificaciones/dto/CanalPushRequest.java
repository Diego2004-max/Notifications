package com.universidad.notificaciones.dto;

import jakarta.validation.constraints.NotBlank;

public class CanalPushRequest {

    @NotBlank(message = "La aplicación es obligatoria.")
    private String aplicacion;

    @NotBlank(message = "La prioridad es obligatoria.")
    private String prioridad;

    public CanalPushRequest() {
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
}