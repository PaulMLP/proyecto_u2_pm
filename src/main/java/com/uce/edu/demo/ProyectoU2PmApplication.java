package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Factura fact = this.facturaService.consultar(1);
		LOG.info("Numero: " + fact.getNumero());
		LOG.info("Fecha: " + fact.getFecha());

		LOG.info("Cliente: " + fact.getCliente().getNumeroTarjeta());

		List<DetalleFactura> detalles = fact.getDetalles();
		for (DetalleFactura detalle : detalles) {
			LOG.info(detalle);
		}
	}
}
