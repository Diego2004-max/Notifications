package com.universidad.notificaciones.repository;

import com.universidad.notificaciones.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}