package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Hotel hotel1 = new Hotel();
		hotel1.setNombre("Hilton Colon UIO");
		hotel1.setDireccion("La patria");
		
		Hotel hotel2 = new Hotel();
		hotel2.setNombre("Hilton Colon GYU");
		hotel2.setDireccion("El Malecon");
		
		LOG.info("Se inserta el Hotel: "+hotel1);
		this.hotelService.insertar(hotel1);
		
		LOG.info("Se inserta el Hotel: "+hotel2);
		this.hotelService.insertar(hotel2);
		
//		Hotel hotel = new Hotel();
//		hotel.setId(1);
//		
//		Habitacion habi1 = new Habitacion();
//		habi1.setNumero("B10");
//		habi1.setPiso("3");
//		habi1.setTipo("Familiar");
//		habi1.setHotel(hotel);
//		
//		Habitacion habi2 = new Habitacion();
//		habi2.setNumero("C20");
//		habi2.setPiso("4");
//		habi2.setTipo("Matrimonial");
//		habi2.setHotel(hotel);
//		
//		LOG.info("Se inserta la habitacion: "+habi1);
//		this.habitacionService.insertar(habi1);
//		
//		LOG.info("Se inserta la habitacion: "+habi2);
//		this.habitacionService.insertar(habi2);
	}
}
