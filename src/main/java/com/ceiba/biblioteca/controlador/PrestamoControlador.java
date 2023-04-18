package com.ceiba.biblioteca.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.mensaje.MensajeExito;
import com.ceiba.biblioteca.modelo.Prestamo;
import com.ceiba.biblioteca.servicio.PrestamoService;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {
	
	@Autowired
	private PrestamoService prestamoService;
	
	@PostMapping("")
	public ResponseEntity<MensajeExito> nuevoPrestamo(@RequestBody Prestamo _prestamo) {
		MensajeExito respuesta = prestamoService.guardarPrestamo(_prestamo);
		return new ResponseEntity<MensajeExito>(respuesta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Prestamo> conseguirPrestamo(@PathVariable("id") long id) {
		Prestamo prestamo = prestamoService.conseguirPrestamo(id);
		return new ResponseEntity<>(prestamo, HttpStatus.OK);
	}
}

