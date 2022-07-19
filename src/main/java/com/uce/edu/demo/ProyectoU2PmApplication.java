package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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

		List<PersonaSencilla> listaPersonaSencilla = this.personaJpaService.buscarPorNombreApellidoSencillo("Armas");
		for (PersonaSencilla perItem : listaPersonaSencilla) {
			LOG.info(perItem);
		}
		
		List<PersonaContadorGenero> listaPersona = this.personaJpaService.consultarCantidadPorGenero();
		for (PersonaContadorGenero perItem : listaPersona) {
			LOG.info(perItem);
		}
	}
}
