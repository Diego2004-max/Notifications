package com.universidad.notificaciones.repository;

import com.universidad.notificaciones.model.entity.CanalNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanalNotificacionRepository extends JpaRepository<CanalNotificacion, Long> {
}