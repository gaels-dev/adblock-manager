/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Componente de mapeo para transformar objetos entre la entidad Dominio y DominioDTO.
 */
package com.gael.adblock.mapper;

import com.gael.adblock.dto.DominioDTO;
import com.gael.adblock.entity.Categoria;
import com.gael.adblock.entity.Dominio;
import org.springframework.stereotype.Component;

@Component
public class DominioMapper {

    public DominioDTO convertirADto(Dominio dominio) {
        if (dominio == null) {
            return null;
        }
        DominioDTO dto = new DominioDTO();
        dto.setId(dominio.getId());
        dto.setDominio(dominio.getDominio());
        dto.setDescripcion(dominio.getDescripcion());
        dto.setActivo(dominio.getActivo());
        dto.setFechaCreacion(dominio.getFechaCreacion());
        dto.setFechaActualizacion(dominio.getFechaActualizacion());
        if (dominio.getCategoria() != null) {
            dto.setCategoriaId(dominio.getCategoria().getId());
            dto.setCategoriaNombre(dominio.getCategoria().getNombre());
        }
        return dto;
    }

    public Dominio convertirAEntidad(DominioDTO dto, Categoria categoria) {
        if (dto == null) {
            return null;
        }
        Dominio dominio = new Dominio();
        dominio.setId(dto.getId());
        dominio.setDominio(dto.getDominio());
        dominio.setDescripcion(dto.getDescripcion());
        if (dto.getActivo() != null) {
            dominio.setActivo(dto.getActivo());
        }
        dominio.setFechaCreacion(dto.getFechaCreacion());
        dominio.setFechaActualizacion(dto.getFechaActualizacion());
        dominio.setCategoria(categoria);
        return dominio;
    }
}
