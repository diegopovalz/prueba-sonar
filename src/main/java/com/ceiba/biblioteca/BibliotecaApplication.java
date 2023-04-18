package com.ceiba.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ceiba.biblioteca.dao.IPrestamo;

@SpringBootApplication(scanBasePackages = {"com.ceiba.biblioteca"})
@EnableJpaRepositories(basePackageClasses = {IPrestamo.class})
@EntityScan(basePackages = {"com.ceiba.biblioteca.modelo"})
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
