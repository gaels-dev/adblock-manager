/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Objeto de transferencia de datos (DTO) para la entidad Dominio.
 */
package com.gael.adblock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DominioDTO {

    private Long id;
    private String dominio;
    private String descripcion;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Long categoriaId;
    private String categoriaNombre;
}
