package com.universidad.notificaciones.service;

import com.universidad.notificaciones.dto.*;
import com.universidad.notificaciones.exception.ResourceNotFoundException;
import com.universidad.notificaciones.model.entity.*;
import com.universidad.notificaciones.repository.CanalNotificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanalNotificacionService {

    private final CanalNotificacionRepository canalRepository;

    public CanalNotificacionService(CanalNotificacionRepository canalRepository) {
        this.canalRepository = canalRepository;
    }

    public CanalResponse crearEmail(CanalEmailRequest request) {
        CanalEmail canal = new CanalEmail();
        canal.setServidorSmtp(request.getServidorSmtp());
        canal.setRemitente(request.getRemitente());
        canal.setAsunto(request.getAsunto());

        return toResponse(canalRepository.save(canal));
    }

    public CanalResponse crearSms(CanalSmsRequest request) {
        CanalSms canal = new CanalSms();
        canal.setProveedorSms(request.getProveedorSms());
        canal.setNumeroOrigen(request.getNumeroOrigen());

        return toResponse(canalRepository.save(canal));
    }

    public CanalResponse crearPush(CanalPushRequest request) {
        CanalPush canal = new CanalPush();
        canal.setAplicacion(request.getAplicacion());
        canal.setPrioridad(request.getPrioridad());

        return toResponse(canalRepository.save(canal));
    }

    public List<CanalResponse> listar() {
        return canalRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CanalResponse obtenerPorId(Long id) {
        return toResponse(buscarEntidad(id));
    }

    public CanalNotificacion buscarEntidad(Long id) {
        return canalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Canal no encontrado con id: " + id));
    }

    private CanalResponse toResponse(CanalNotificacion canal) {
        if (canal instanceof CanalEmail email) {
            return new CanalResponse(
                    email.getId(),
                    "EMAIL",
                    email.getServidorSmtp(),
                    email.getRemitente(),
                    email.getAsunto()
            );
        }

        if (canal instanceof CanalSms sms) {
            return new CanalResponse(
                    sms.getId(),
                    "SMS",
                    sms.getProveedorSms(),
                    sms.getNumeroOrigen(),
                    null
            );
        }

        if (canal instanceof CanalPush push) {
            return new CanalResponse(
                    push.getId(),
                    "PUSH",
                    push.getAplicacion(),
                    push.getPrioridad(),
                    null
            );
        }

        return new CanalResponse(canal.getId(), "DESCONOCIDO", null, null, null);
    }
}