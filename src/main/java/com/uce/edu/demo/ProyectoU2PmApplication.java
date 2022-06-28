package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setId(2);
		persona.setNombre("Leonardo");
		persona.setApellido("Proaño");

		// Insertar
		// this.iPersonaJdbcService.guardar(persona);

		// Buscar
		LOG.info((this.iPersonaJdbcService.buscarPersona(1)));

		// Actualizar
//		Persona per1 = new Persona();
//		per1.setId(2);
//		per1.setNombre("Leonardo");
//		per1.setApellido("Yanez");
//		this.iPersonaJdbcService.actualizar(per1);

		// Eliminar
		// this.iPersonaJdbcService.eliminar(3);
	}

}
