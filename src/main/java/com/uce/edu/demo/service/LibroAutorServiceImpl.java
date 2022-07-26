package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroAutorRepo;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;

@Service
public class LibroAutorServiceImpl implements ILibroAutorService {

	@Autowired
	private ILibroAutorRepo libroAutorRepo;

	@Override
	public void insertar(Libro2Autor2 libroautor) {
		this.libroAutorRepo.insertar(libroautor);
	}

}
