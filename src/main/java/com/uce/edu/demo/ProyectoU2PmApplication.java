package com.uce.edu.demo;

import java.util.List;

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
		est.setApellido("Merizalde");
		est.setCedula("1728189521");
		est.setCarrera("Ing Computacion");
		est.setSemestre(3);
		est.setEdad(22);
		est.setGenero("M");
		this.estudianteJpaService.guardar(est);

		// 1. TypedQuery
		LOG.info("Estudiante Typed: " + this.estudianteJpaService.buscarPorCedula("1728189521"));

		List<Estudiante> listaEstudiante = this.estudianteJpaService.buscarPorApellidoGenero("Merizalde", "M");
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante Typed: " + item);
		}
		
		// 2. NamedQuery
		listaEstudiante = this.estudianteJpaService.buscarPorSemestre(1);
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante Named: " + item);
		}
		
		listaEstudiante = this.estudianteJpaService.buscarPorEdad(17);
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante Named: " + item);
		}
		// 3. TypedQuery y NamedQuery
		listaEstudiante = this.estudianteJpaService.buscarPorEdadGenero(18, "M");
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante TypedNamed: " + item);
		}
		
		listaEstudiante = this.estudianteJpaService.buscarPorCarreraSemestre("Ing Computacion", 3);
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante TypedNamed: " + item);
		}
	}
}
