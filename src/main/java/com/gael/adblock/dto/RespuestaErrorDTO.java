/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Objeto de transferencia de datos para estandarizar las respuestas HTTP de error.
 */
package com.gael.adblock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RespuestaErrorDTO {

    private LocalDateTime fechaHora;
    private int codigoEstado;
    private String error;
    private String mensaje;
    private String ruta;

    public RespuestaErrorDTO(LocalDateTime fechaHora, int codigoEstado, String error, String mensaje, String ruta) {
        this.fechaHora = fechaHora;
        this.codigoEstado = codigoEstado;
        this.error = error;
        this.mensaje = mensaje;
        this.ruta = ruta;
    }
}
