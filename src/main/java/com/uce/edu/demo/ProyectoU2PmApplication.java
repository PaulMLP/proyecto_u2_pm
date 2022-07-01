package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante est = new Estudiante();
		est.setNombre("Paul");
		est.setApellido("Perez");
		est.setCarrera("Arquitectura");
		est.setSemestre("2");
		est.setId(1);

		// Guardar
		this.estudianteJpaService.insertar(est);

		// Buscar
		LOG.info("Dato con JPA: " + this.estudianteJpaService.buscarEstudiante(1));
				
				
		// Actualizar
		Estudiante est1 = new Estudiante();
		est1.setId(1);
		est1.setNombre("Paul");
		est1.setApellido("Perez");
		est1.setCarrera("Ingenieria Civil");
		est1.setSemestre("3");
		this.estudianteJpaService.actualizar(est1);
		
		// Eliminar
		this.estudianteJpaService.eliminar(1);
	}

}
