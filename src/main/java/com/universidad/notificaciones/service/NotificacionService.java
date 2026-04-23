package com.universidad.notificaciones.service;

import com.universidad.notificaciones.dto.NotificacionRequest;
import com.universidad.notificaciones.dto.NotificacionResponse;
import com.universidad.notificaciones.exception.BusinessException;
import com.universidad.notificaciones.exception.ResourceNotFoundException;
import com.universidad.notificaciones.model.entity.CanalEmail;
import com.universidad.notificaciones.model.entity.CanalNotificacion;
import com.universidad.notificaciones.model.entity.CanalPush;
import com.universidad.notificaciones.model.entity.CanalSms;
import com.universidad.notificaciones.model.entity.Notificacion;
import com.universidad.notificaciones.model.entity.Usuario;
import com.universidad.notificaciones.model.enums.EstadoNotificacion;
import com.universidad.notificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private final UsuarioService usuarioService;
    private final CanalNotificacionService canalService;

    public NotificacionService(NotificacionRepository notificacionRepository,
                               UsuarioService usuarioService,
                               CanalNotificacionService canalService) {
        this.notificacionRepository = notificacionRepository;
        this.usuarioService = usuarioService;
        this.canalService = canalService;
    }

    public NotificacionResponse crear(NotificacionRequest request) {
        notificacionRepository.findByCodigo(request.getCodigo())
                .ifPresent(n -> {
                    throw new BusinessException("Ya existe una notificación con el código: " + request.getCodigo());
                });

        Usuario usuario = usuarioService.buscarEntidad(request.getDestinatarioId());
        CanalNotificacion canal = canalService.buscarEntidad(request.getCanalId());

        Notificacion notificacion = new Notificacion();
        notificacion.setCodigo(request.getCodigo());
        notificacion.setMensaje(request.getMensaje());
        notificacion.setTipo(request.getTipo());
        notificacion.setEstado(EstadoNotificacion.PENDIENTE);
        notificacion.setDestinatario(usuario);
        notificacion.setCanal(canal);

        return toResponse(notificacionRepository.save(notificacion));
    }

    public List<NotificacionResponse> listar() {
        return notificacionRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public NotificacionResponse obtenerPorId(Long id) {
        return toResponse(buscarEntidad(id));
    }

    @Transactional
    public NotificacionResponse enviar(Long id) {
        Notificacion notificacion = buscarEntidad(id);

        try {
            notificacion.enviar();
            notificacion.setEstado(EstadoNotificacion.ENVIADA);
            notificacion.setFechaEnvio(LocalDateTime.now());
        } catch (Exception e) {
            notificacion.setEstado(EstadoNotificacion.FALLIDA);
            notificacion.setFechaEnvio(LocalDateTime.now());
            throw e;
        }

        return toResponse(notificacionRepository.save(notificacion));
    }

    public Notificacion buscarEntidad(Long id) {
        return notificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notificación no encontrada con id: " + id));
    }

    private NotificacionResponse toResponse(Notificacion notificacion) {
        return new NotificacionResponse(
                notificacion.getId(),
                notificacion.getCodigo(),
                notificacion.getMensaje(),
                notificacion.getFechaEnvio(),
                notificacion.getEstado(),
                notificacion.getTipo(),
                notificacion.getDestinatario().getId(),
                notificacion.getDestinatario().getNombre(),
                notificacion.getCanal().getId(),
                obtenerTipoCanal(notificacion.getCanal())
        );
    }

    private String obtenerTipoCanal(CanalNotificacion canal) {
        if (canal instanceof CanalEmail) {
            return "EMAIL";
        }
        if (canal instanceof CanalSms) {
            return "SMS";
        }
        if (canal instanceof CanalPush) {
            return "PUSH";
        }
        return "DESCONOCIDO";
    }
}