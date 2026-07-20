/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Repositorio para la gestión de acceso a datos de la entidad Lista.
 */
package com.gael.adblock.repository;

import com.gael.adblock.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {

    Optional<Lista> findByNombre(String nombre);
}
