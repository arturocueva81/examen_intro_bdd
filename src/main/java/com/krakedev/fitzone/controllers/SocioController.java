package com.krakedev.fitzone.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.services.ServicioSocio;

@RestController
@RequestMapping("/socios")
public class SocioController {

	private final ServicioSocio servicio;

	public SocioController(ServicioSocio servicio) {
		this.servicio = servicio;
	}

	//POST/socios
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Socio socio) {
		try {
			Socio creado = servicio.crear(socio);
			return ResponseEntity.status(HttpStatus.CREATED).body(creado);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear registro");
		}
	}
	
	// GET/socios
	@GetMapping
	public ResponseEntity<?> listar() {
		try {
			List<Socio> socios = servicio.listar();
			return ResponseEntity.ok(socios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar los socios");
		}
	}

	//GET /socios/estado?activo=true
	@GetMapping("/estado")
	public ResponseEntity<?> buscarPorEstado(@RequestParam boolean activo) {
		try {
			List<Socio> socios = servicio.buscarPorEstado(activo);
			return ResponseEntity.ok(socios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por estado");
		}
	}
}