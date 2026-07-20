/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Objeto de transferencia de datos (DTO) para la entidad Lista.
 */
package com.gael.adblock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ListaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private Set<Long> dominiosIds = new HashSet<>();
}
