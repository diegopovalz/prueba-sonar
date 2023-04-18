package com.ceiba.biblioteca.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ceiba.biblioteca.mensaje.MensajeError;

@ControllerAdvice
public class ManejadorErrorPrestamo {
	
	@ExceptionHandler(ExcepcionProblemaPrestamo.class)
	public ResponseEntity<MensajeError> manejarProblema(ExcepcionProblemaPrestamo e) {
		MensajeError error = new MensajeError(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
