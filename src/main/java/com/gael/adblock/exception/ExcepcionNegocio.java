/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Excepción genérica de reglas o lógica de negocio no cumplidas.
 */
package com.gael.adblock.exception;

public class ExcepcionNegocio extends RuntimeException {

    public ExcepcionNegocio(String mensaje) {
        super(mensaje);
    }
}
