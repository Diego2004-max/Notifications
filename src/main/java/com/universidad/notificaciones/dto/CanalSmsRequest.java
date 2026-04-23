package com.universidad.notificaciones.dto;

import jakarta.validation.constraints.NotBlank;

public class CanalSmsRequest {

    @NotBlank(message = "El proveedor SMS es obligatorio.")
    private String proveedorSms;

    @NotBlank(message = "El número origen es obligatorio.")
    private String numeroOrigen;

    public CanalSmsRequest() {
    }

    public String getProveedorSms() {
        return proveedorSms;
    }

    public void setProveedorSms(String proveedorSms) {
        this.proveedorSms = proveedorSms;
    }

    public String getNumeroOrigen() {
        return numeroOrigen;
    }

    public void setNumeroOrigen(String numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }
}