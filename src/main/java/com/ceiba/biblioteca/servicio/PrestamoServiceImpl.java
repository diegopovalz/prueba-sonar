package com.ceiba.biblioteca.servicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.biblioteca.dao.IPrestamo;
import com.ceiba.biblioteca.excepcion.ExcepcionProblemaPrestamo;
import com.ceiba.biblioteca.mensaje.MensajeExito;
import com.ceiba.biblioteca.modelo.Prestamo;

@Service
public class PrestamoServiceImpl implements PrestamoService {
	
	@Autowired
	private IPrestamo prestamoRepository;
	
	private final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public MensajeExito guardarPrestamo(Prestamo _prestamo) {
		Prestamo prestamo = prestamoRepository.findByIdentificacionUsuario(_prestamo.getIdentificacionUsuario());
		if(prestamo != null && prestamo.getTipoUsuario() == 3) {
			throw new ExcepcionProblemaPrestamo("El usuario con identificaci\u00f3n " + _prestamo.getIdentificacionUsuario() + " ya tiene un libro prestado por lo cual no se le puede realizar otro pr\u00e9stamo");
		}
		
		if(_prestamo.getTipoUsuario() < 1 || _prestamo.getTipoUsuario() > 3) {
			throw new ExcepcionProblemaPrestamo("Tipo de usuario no permitido en la biblioteca");
		}
		
		LocalDate fecha = LocalDate.now();
		int diasPlazo = 0;
		int diasAgregados = 0;
		switch(_prestamo.getTipoUsuario()) {
			case 1:
				diasPlazo = 10;
				break;
			case 2:
				diasPlazo = 8;
				break;
			case 3:
				diasPlazo = 7;
				break;
		}
		
		while(diasAgregados < diasPlazo) {
			fecha = fecha.plusDays(1);
			if(fecha.getDayOfWeek() != DayOfWeek.SATURDAY && fecha.getDayOfWeek() != DayOfWeek.SUNDAY) {
				diasAgregados++;
			}
		}
		
		Date fechaMaxima = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		_prestamo.setFechaMaximaDevolucion(formatter.format(fechaMaxima));
		
		prestamo = prestamoRepository.save(_prestamo);
		return new MensajeExito(prestamo.getId(), formatter.format(fechaMaxima));
	}

	public Prestamo conseguirPrestamo(long id) {
		Prestamo prestamo = prestamoRepository.findById(id)
				.orElseThrow(() -> new ExcepcionProblemaPrestamo("No hay ning\u00fan prestamo registrado con el ID proporcionado"));
		return prestamo;
	}
}
