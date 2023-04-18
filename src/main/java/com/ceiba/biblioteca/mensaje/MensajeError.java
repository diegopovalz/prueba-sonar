package com.ceiba.biblioteca.mensaje;

public class MensajeError {
	private String mensaje;

	public MensajeError(String mensaje) {
	    this.setMensaje(mensaje);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
