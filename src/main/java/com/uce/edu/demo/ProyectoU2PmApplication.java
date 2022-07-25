package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Pasajero;
import com.uce.edu.demo.repository.modelo.onetomany.Transporte;
import com.uce.edu.demo.service.ITransporteService;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private ITransporteService transporteService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Transporte transporte = new Transporte();
		transporte.setPlaca("PIB001");
		transporte.setNombre("A10P");
		transporte.setCooperativa("Reino de Quito");

		LOG.info("Se inserta: "+transporte);
		this.transporteService.insertar(transporte);
		
		LOG.info("Se encontro: "+this.transporteService.buscar("A10P"));		
		LOG.info("Se actualizo: " + this.transporteService.actualizar("PIB001", "Zabala")+" transporte(s)");
		
		LOG.info("Se elimino: "+this.transporteService.eliminar("PIB001")+" transporte(s)");
	}
}
