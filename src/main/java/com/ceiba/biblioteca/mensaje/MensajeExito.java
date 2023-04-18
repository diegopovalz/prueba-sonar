package com.ceiba.biblioteca.mensaje;

public class MensajeExito {
	private Long id;
	private String fechaMaximaDevolucion;
	
	public MensajeExito(Long id, String fechaMaximaDevolucion) {
		this.id = id;
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}
	public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
	
}
