package com.universidad.notificaciones.controller;

import com.universidad.notificaciones.dto.*;
import com.universidad.notificaciones.service.CanalNotificacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canales")
public class CanalNotificacionController {

    private final CanalNotificacionService canalService;

    public CanalNotificacionController(CanalNotificacionService canalService) {
        this.canalService = canalService;
    }

    @PostMapping("/email")
    @ResponseStatus(HttpStatus.CREATED)
    public CanalResponse crearEmail(@Valid @RequestBody CanalEmailRequest request) {
        return canalService.crearEmail(request);
    }

    @PostMapping("/sms")
    @ResponseStatus(HttpStatus.CREATED)
    public CanalResponse crearSms(@Valid @RequestBody CanalSmsRequest request) {
        return canalService.crearSms(request);
    }

    @PostMapping("/push")
    @ResponseStatus(HttpStatus.CREATED)
    public CanalResponse crearPush(@Valid @RequestBody CanalPushRequest request) {
        return canalService.crearPush(request);
    }

    @GetMapping
    public List<CanalResponse> listar() {
        return canalService.listar();
    }

    @GetMapping("/{id}")
    public CanalResponse obtenerPorId(@PathVariable Long id) {
        return canalService.obtenerPorId(id);
    }
}