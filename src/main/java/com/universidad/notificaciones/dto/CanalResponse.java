package com.universidad.notificaciones.dto;

public class CanalResponse {

    private Long id;
    private String tipo;
    private String detalle1;
    private String detalle2;
    private String detalle3;

    public CanalResponse() {
    }

    public CanalResponse(Long id, String tipo, String detalle1, String detalle2, String detalle3) {
        this.id = id;
        this.tipo = tipo;
        this.detalle1 = detalle1;
        this.detalle2 = detalle2;
        this.detalle3 = detalle3;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDetalle1() {
        return detalle1;
    }

    public String getDetalle2() {
        return detalle2;
    }

    public String getDetalle3() {
        return detalle3;
    }
}