package com.universidad.notificaciones.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "canales_notificacion")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CanalNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public CanalNotificacion() {
    }

    public Long getId() {
        return id;
    }

    public abstract void enviar(Notificacion notificacion);
}