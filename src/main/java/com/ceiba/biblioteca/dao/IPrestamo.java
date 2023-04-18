package com.ceiba.biblioteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.biblioteca.modelo.Prestamo;

public interface IPrestamo extends JpaRepository<Prestamo, Long> {
	Prestamo findByIdentificacionUsuario(String identificacionUsuario);
}
