package com.universidad.notificaciones.repository;

import com.universidad.notificaciones.model.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    Optional<Notificacion> findByCodigo(String codigo);
}