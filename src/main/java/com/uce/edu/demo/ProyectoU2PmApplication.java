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

		Estudiante e = this.estudianteJpaService.buscarPorCedulaNative("1728189521");
		LOG.info("Native Estudiante: " + e);

		List<Estudiante> listaEstu = this.estudianteJpaService.buscarPorSemestreCarreraNative(3, "Ing Computacion");
		for (Estudiante est : listaEstu) {
			LOG.info("Native Estudiante: " + est);
		}

		listaEstu = this.estudianteJpaService.buscarPorApellidoNombreNamedNative("Merizalde", "Paul");
		for (Estudiante est : listaEstu) {
			LOG.info("Native Estudiante: " + est);
		}
		listaEstu = this.estudianteJpaService.buscarPorGeneroEdadNamedNative("M", 22);
		for (Estudiante est : listaEstu) {
			LOG.info("Native Estudiante: " + est);
		}

	}
}
