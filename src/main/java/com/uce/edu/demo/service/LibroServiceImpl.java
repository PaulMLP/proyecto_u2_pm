package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;

@Service
public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibroRepository libroRepository;
	
	@Override
	public void insertar(Libro libro) {
		this.libroRepository.insertar(libro);
	}

}
