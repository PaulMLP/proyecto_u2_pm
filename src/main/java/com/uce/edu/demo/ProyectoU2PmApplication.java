package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private IPersonaJpaService personaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Buscar
		LOG.info("Dato con JPA: " + this.personaJpaService.buscarPorId(1));
		Persona per = new Persona();
		per.setId(5);
		per.setNombre("Pepito");
		per.setApellido("Perez");

		// Guardar
		this.personaJpaService.guardar(per);

		// Actualizar
		Persona per1 = new Persona();
		per1.setId(2);
		per1.setNombre("David");
		per1.setApellido("Mendez");
		this.personaJpaService.actualizar(per1);

		// Eliminar
		this.personaJpaService.eliminar(1);
	}

}
