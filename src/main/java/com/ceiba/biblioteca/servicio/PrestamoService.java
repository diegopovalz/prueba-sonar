package com.ceiba.biblioteca.servicio;

import com.ceiba.biblioteca.mensaje.MensajeExito;
import com.ceiba.biblioteca.modelo.Prestamo;

public interface PrestamoService {
	MensajeExito guardarPrestamo(Prestamo prestamo); 
	
	Prestamo conseguirPrestamo(long id);
}
