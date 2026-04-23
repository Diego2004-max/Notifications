package com.universidad.notificaciones.dto;

import jakarta.validation.constraints.NotBlank;

public class CanalEmailRequest {

    @NotBlank(message = "El servidor SMTP es obligatorio.")
    private String servidorSmtp;

    @NotBlank(message = "El remitente es obligatorio.")
    private String remitente;

    @NotBlank(message = "El asunto es obligatorio.")
    private String asunto;

    public CanalEmailRequest() {
    }

    public String getServidorSmtp() {
        return servidorSmtp;
    }

    public void setServidorSmtp(String servidorSmtp) {
        this.servidorSmtp = servidorSmtp;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}