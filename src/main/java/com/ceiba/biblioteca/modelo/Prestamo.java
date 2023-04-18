package com.ceiba.biblioteca.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String identificacionUsuario;
	private int tipoUsuario;
	private String fechaMaximaDevolucion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}
	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}
	public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
	
}
