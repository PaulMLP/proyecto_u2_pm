package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.to.Estudiante;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private IEstudianteJdbcService iEstudianteJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Estudiante estudiante = new Estudiante();
		estudiante.setId(1);
		estudiante.setNombre("Paul");
		estudiante.setApellido("Merizalde");
		estudiante.setCarrera("Ingenieria en Computacion");
		estudiante.setSemestre("5");

		// Insertar
		this.iEstudianteJdbcService.guardar(estudiante);

		// Buscar
		LOG.info((this.iEstudianteJdbcService.buscarEstudiante(1)));

		// Actualizar
		Estudiante est1 = new Estudiante();
		est1.setId(1);
		est1.setNombre("Paul");
		est1.setApellido("Merizalde");
		est1.setCarrera("Ingenieria en Computacion");
		est1.setSemestre("6");
		this.iEstudianteJdbcService.actualizar(est1);

		// Eliminar
		//this.iEstudianteJdbcService.eliminar(1);
	}

}
