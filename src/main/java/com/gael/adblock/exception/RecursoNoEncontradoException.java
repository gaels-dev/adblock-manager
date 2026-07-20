/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Excepción lanzada cuando no se encuentra un recurso en el sistema.
 */
package com.gael.adblock.exception;

public class RecursoNoEncontradoException extends RuntimeException {

    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
