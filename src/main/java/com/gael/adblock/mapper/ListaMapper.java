/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Componente de mapeo para transformar objetos entre la entidad Lista y ListaDTO.
 */
package com.gael.adblock.mapper;

import com.gael.adblock.dto.ListaDTO;
import com.gael.adblock.entity.Dominio;
import com.gael.adblock.entity.Lista;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
public class ListaMapper {

    public ListaDTO convertirADto(Lista lista) {
        if (lista == null) {
            return null;
        }
        ListaDTO dto = new ListaDTO();
        dto.setId(lista.getId());
        dto.setNombre(lista.getNombre());
        dto.setDescripcion(lista.getDescripcion());
        dto.setFechaCreacion(lista.getFechaCreacion());
        Set<Long> dominiosIds = new HashSet<>();
        if (lista.getDominios() != null) {
            for (Dominio dominio : lista.getDominios()) {
                dominiosIds.add(dominio.getId());
            }
        }
        dto.setDominiosIds(dominiosIds);
        return dto;
    }

    public Lista convertirAEntidad(ListaDTO dto, Set<Dominio> dominios) {
        if (dto == null) {
            return null;
        }
        Lista lista = new Lista();
        lista.setId(dto.getId());
        lista.setNombre(dto.getNombre());
        lista.setDescripcion(dto.getDescripcion());
        lista.setFechaCreacion(dto.getFechaCreacion());
        if (dominios != null) {
            lista.setDominios(dominios);
        } else {
            lista.setDominios(new HashSet<>());
        }
        return lista;
    }
}
