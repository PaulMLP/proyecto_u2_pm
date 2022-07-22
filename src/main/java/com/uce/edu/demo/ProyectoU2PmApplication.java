package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre("David");
		ciudadano.setApellido("Mendez");
		ciudadano.setCedula("16486816");
		ciudadano.setFechaNacimiento(LocalDateTime.now());

		Pasaporte pasaporte = new Pasaporte();
		pasaporte.setNumero(555);
		pasaporte.setFechaEmision(LocalDateTime.now());
		pasaporte.setFechaCaducidad(LocalDateTime.now());
		pasaporte.setCiudadano(ciudadano);

		ciudadano.setPasaporte(pasaporte);

		// Insertar ciudadano
		LOG.info("Insercion de : "+ ciudadano);
		this.ciudadanoService.insertar(ciudadano);
		
		
		// Buscar ciudadano
		Ciudadano c = this.ciudadanoService.buscar("16486816");
		LOG.info("Busqueda: " + c);
		
		// Actualizar ciudadano
		LOG.info("Se Actualizo: " + this.ciudadanoService.actualizar("16486816", "Hugo"));

		// Eliminar ciudadano
		LOG.info("Se Elimino" + this.ciudadanoService.eliminar("16486816"));
	}
}
