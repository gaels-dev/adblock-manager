/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Manejador global de excepciones para centralizar las respuestas de error de la API REST.
 */
package com.gael.adblock.exception;

import com.gael.adblock.dto.RespuestaErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<RespuestaErrorDTO> manejarRecursoNoEncontrado(
            RecursoNoEncontradoException ex, HttpServletRequest peticion) {
        RespuestaErrorDTO respuesta = new RespuestaErrorDTO(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Recurso No Encontrado",
            ex.getMessage(),
            peticion.getRequestURI()
        );
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DominioInvalidoException.class)
    public ResponseEntity<RespuestaErrorDTO> manejarDominioInvalido(
            DominioInvalidoException ex, HttpServletRequest peticion) {
        RespuestaErrorDTO respuesta = new RespuestaErrorDTO(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Dominio Inválido",
            ex.getMessage(),
            peticion.getRequestURI()
        );
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExcepcionNegocio.class)
    public ResponseEntity<RespuestaErrorDTO> manejarExcepcionNegocio(
            ExcepcionNegocio ex, HttpServletRequest peticion) {
        RespuestaErrorDTO respuesta = new RespuestaErrorDTO(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Error de Negocio",
            ex.getMessage(),
            peticion.getRequestURI()
        );
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarValidacionArgumentos(
            MethodArgumentNotValidException ex, HttpServletRequest peticion) {
        Map<String, String> errores = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("fechaHora", LocalDateTime.now());
        respuesta.put("codigoEstado", HttpStatus.BAD_REQUEST.value());
        respuesta.put("error", "Error de Validación de Campos");
        respuesta.put("detalles", errores);
        respuesta.put("ruta", peticion.getRequestURI());

        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaErrorDTO> manejarExcepcionGeneral(
            Exception ex, HttpServletRequest peticion) {
        RespuestaErrorDTO respuesta = new RespuestaErrorDTO(
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Error Interno del Servidor",
            ex.getMessage(),
            peticion.getRequestURI()
        );
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
