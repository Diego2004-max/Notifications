package com.universidad.notificaciones.controller;

import com.universidad.notificaciones.dto.NotificacionRequest;
import com.universidad.notificaciones.dto.NotificacionResponse;
import com.universidad.notificaciones.service.NotificacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificacionResponse crear(@Valid @RequestBody NotificacionRequest request) {
        return notificacionService.crear(request);
    }

    @GetMapping
    public List<NotificacionResponse> listar() {
        return notificacionService.listar();
    }

    @GetMapping("/{id}")
    public NotificacionResponse obtenerPorId(@PathVariable Long id) {
        return notificacionService.obtenerPorId(id);
    }

    @PostMapping("/{id}/enviar")
    public NotificacionResponse enviar(@PathVariable Long id) {
        return notificacionService.enviar(id);
    }
}