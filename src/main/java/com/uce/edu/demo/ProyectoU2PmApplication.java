package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Autor2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;
import com.uce.edu.demo.service.IAutor2Service;
import com.uce.edu.demo.service.ILibro2Service;
import com.uce.edu.demo.service.ILibroAutorService;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private ILibro2Service libroService;
	
	@Autowired
	private IAutor2Service autor2Service;
	
	@Autowired
	private ILibroAutorService libroAutorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Un libro con dos autores
//		Libro2 libro = new Libro2();
//		libro.setTitulo("Brevisima historia del tiempo");
//		libro.setCantidadPaginas(300);
//		
//		this.libroService.insertar(libro);
			
//		Autor2 autor = new Autor2();
//		autor.setNombre("Stephen Hawking");
//	
//		Autor2 autor2 = new Autor2();
//		autor2.setNombre("Leonard Mlodinow");
//		
//		this.autor2Service.insertar(autor);
//		this.autor2Service.insertar(autor2);	
		
//		Libro2 libro = new Libro2();
//		libro.setId(4);
//
//		Autor2 autor = new Autor2();
//		autor.setId(3);
//		
//		Autor2 autor2 = new Autor2();
//		autor2.setId(4);
//		
//		
//		Libro2Autor2 la1 = new Libro2Autor2();
//		la1.setLibro2(libro);
//		la1.setAutor2(autor);
//		
//		Libro2Autor2 la2 = new Libro2Autor2();
//		la2.setLibro2(libro);
//		la2.setAutor2(autor2);
//
//		this.libroAutorService.insertar(la1);
//		this.libroAutorService.insertar(la2);
		
	
		// Un autor con dos libros
		
//		Autor2 autor3 = new Autor2();
//		autor3.setNombre("J.R.R. Tolkien");
//		
//		this.autor2Service.insertar(autor3);
		
//		Libro2 libro3 = new Libro2();
//		libro3.setTitulo("El Hobbit");
//		libro3.setCantidadPaginas(300);
//		
//		Libro2 libro4 = new Libro2();
//		libro4.setTitulo("Los Hijos de Hurin");
//		libro4.setCantidadPaginas(250);
//		
//		this.libroService.insertar(libro3);
//		this.libroService.insertar(libro4);
		
		
		Autor2 autor3 = new Autor2();
		autor3.setId(1);
		
		Libro2 libro3 = new Libro2();
		libro3.setId(1);
		
		Libro2 libro4 = new Libro2();
		libro4.setId(2);
		
		Libro2Autor2 la3 = new Libro2Autor2();
		la3.setAutor2(autor3);
		la3.setLibro2(libro3);
		
		Libro2Autor2 la4 = new Libro2Autor2();
		la4.setAutor2(autor3);
		la4.setLibro2(libro4);
		
		this.libroAutorService.insertar(la3);
		this.libroAutorService.insertar(la4);

	}
}
