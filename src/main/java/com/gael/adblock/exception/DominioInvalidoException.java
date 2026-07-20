/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Excepción lanzada cuando un dominio no cumple con el formato FQDN válido.
 */
package com.gael.adblock.exception;

public class DominioInvalidoException extends RuntimeException {

    public DominioInvalidoException(String mensaje) {
        super(mensaje);
    }
}
