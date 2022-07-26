package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);

	@Autowired
	private ILibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Libro libro = new Libro();
		libro.setTitulo("El Hobbit");
		libro.setCantidadPaginas(250);
		
		Autor autor = new Autor();
		autor.setNombre("J.R.R. Tolkien");
		
		Set<Autor> listaAutores = new HashSet<>();
		listaAutores.add(autor);
		
		libro.setAutores(listaAutores);
		this.libroService.insertar(libro);
	}
}
