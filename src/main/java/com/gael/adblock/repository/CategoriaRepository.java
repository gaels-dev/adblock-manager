/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Repositorio para la gestión de acceso a datos de la entidad Categoria.
 */
package com.gael.adblock.repository;

import com.gael.adblock.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNombre(String nombre);
}
