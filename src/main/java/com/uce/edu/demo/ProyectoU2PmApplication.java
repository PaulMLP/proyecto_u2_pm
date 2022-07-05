package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
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
		// TODO Auto-generated method stub
		// Buscar
//		LOG.info("Dato con JPA: " + this.personaJpaService.buscarPorId(1));
		
		// Guardar
		Persona per = new Persona();
		per.setNombre("Juanito");
		per.setApellido("Alimania");
		this.personaJpaService.guardar(per);

//		// Actualizar
//		Persona per1 = new Persona();
//		per1.setId(7);
//		per1.setNombre("Paul");
//		per1.setApellido("Merizalde");
//		this.personaJpaService.actualizar(per1);

//		// Eliminar
//		this.personaJpaService.eliminar(1);
	}
}
