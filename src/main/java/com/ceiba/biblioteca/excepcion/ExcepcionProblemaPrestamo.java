package com.ceiba.biblioteca.excepcion;

public class ExcepcionProblemaPrestamo extends RuntimeException {

	private static final long serialVersionUID = 1L;
 
	public ExcepcionProblemaPrestamo(String mensaje) {
		super(mensaje);
	}
}
