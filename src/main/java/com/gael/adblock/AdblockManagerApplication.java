/**
 * Autor: gaels-dev
 * Fecha creación: 2026-07-20
 * Descripción: Clase principal de arranque de la aplicación AdBlock Manager con Spring Boot.
 */
package com.gael.adblock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdblockManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdblockManagerApplication.class, args);
	}

}
