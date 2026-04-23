package com.universidad.notificaciones.model.entity;

import com.universidad.notificaciones.exception.BusinessException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "canales_sms")
public class CanalSms extends CanalNotificacion {

    @Column(name = "proveedor_sms", nullable = false)
    private String proveedorSms;

    @Column(name = "numero_origen", nullable = false)
    private String numeroOrigen;

    public CanalSms() {
    }

    public CanalSms(String proveedorSms, String numeroOrigen) {
        this.proveedorSms = proveedorSms;
        this.numeroOrigen = numeroOrigen;
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

    @Override
    public void enviar(Notificacion notificacion) {
        String telefonoDestino = notificacion.getDestinatario().getTelefono();

        if (telefonoDestino == null || telefonoDestino.isBlank()) {
            throw new BusinessException("El usuario no tiene número telefónico registrado.");
        }

        System.out.println("=== ENVIO SMS ===");
        System.out.println("Proveedor: " + proveedorSms);
        System.out.println("Número origen: " + numeroOrigen);
        System.out.println("Destino: " + telefonoDestino);
        System.out.println("Mensaje: " + notificacion.getMensaje());
    }
}