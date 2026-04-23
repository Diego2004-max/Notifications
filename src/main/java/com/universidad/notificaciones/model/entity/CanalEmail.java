package com.universidad.notificaciones.model.entity;

import com.universidad.notificaciones.exception.BusinessException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "canales_email")
public class CanalEmail extends CanalNotificacion {

    @Column(name = "servidor_smtp", nullable = false)
    private String servidorSmtp;

    @Column(nullable = false)
    private String remitente;

    @Column(nullable = false)
    private String asunto;

    public CanalEmail() {
    }

    public CanalEmail(String servidorSmtp, String remitente, String asunto) {
        this.servidorSmtp = servidorSmtp;
        this.remitente = remitente;
        this.asunto = asunto;
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

    @Override
    public void enviar(Notificacion notificacion) {
        String emailDestino = notificacion.getDestinatario().getEmail();

        if (emailDestino == null || emailDestino.isBlank()) {
            throw new BusinessException("El usuario no tiene correo electrónico registrado.");
        }

        System.out.println("=== ENVIO EMAIL ===");
        System.out.println("SMTP: " + servidorSmtp);
        System.out.println("Remitente: " + remitente);
        System.out.println("Asunto: " + asunto);
        System.out.println("Destino: " + emailDestino);
        System.out.println("Mensaje: " + notificacion.getMensaje());
    }
}