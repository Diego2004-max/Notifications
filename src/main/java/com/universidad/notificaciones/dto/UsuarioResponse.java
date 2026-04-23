package com.universidad.notificaciones.dto;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String tokenDispositivo;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String nombre, String email, String telefono, String tokenDispositivo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.tokenDispositivo = tokenDispositivo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTokenDispositivo() {
        return tokenDispositivo;
    }
}