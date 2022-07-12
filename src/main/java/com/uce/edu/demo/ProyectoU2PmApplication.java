package com.uce.edu.demo;

import java.util.List;

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
		Persona per1 = new Persona();
		per1.setApellido("Gonzalez");
		per1.setNombre("Daniel");
		per1.setCedula("3212141");
		per1.setGenero("M");
		//this.personaJpaService.guardar(per1);
		
		// 1. TypedQuery
		Persona perTyped= this.personaJpaService.buscarPorCedulaTyped("177777777");
		LOG.info("Persona Typed: "+perTyped);
		
		//2. NamedQuery
		Persona perNamed = this.personaJpaService.buscarPorCedulaNamed("177777777");
		LOG.info("Persona Named: "+perNamed);
		
		//3. TypedQuery y NamedQuery
		Persona perTypedNamed = this.personaJpaService.buscarPorCedulaTypedNamed("177777777");
		LOG.info("Persona TypedNamed: "+perTypedNamed);
		
		List<Persona> listaPersona = this.personaJpaService.buscarPorNombreApellido("Daniel", "Gonzalez");
		for (Persona item : listaPersona) {
			LOG.info("Persona TypedNamed: " + item);
		}
	}
}
