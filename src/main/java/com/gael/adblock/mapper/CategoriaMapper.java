/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Componente de mapeo para transformar objetos entre la entidad Categoria y CategoriaDTO.
 */
package com.gael.adblock.mapper;

import com.gael.adblock.dto.CategoriaDTO;
import com.gael.adblock.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaDTO convertirADto(Categoria categoria) {
        if (categoria == null) {
            return null;
        }
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        dto.setActivo(categoria.getActivo());
        dto.setFechaCreacion(categoria.getFechaCreacion());
        return dto;
    }

    public Categoria convertirAEntidad(CategoriaDTO dto) {
        if (dto == null) {
            return null;
        }
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        if (dto.getActivo() != null) {
            categoria.setActivo(dto.getActivo());
        }
        categoria.setFechaCreacion(dto.getFechaCreacion());
        return categoria;
    }
}
