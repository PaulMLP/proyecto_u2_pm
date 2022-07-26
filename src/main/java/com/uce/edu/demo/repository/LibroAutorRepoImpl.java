package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;

@Repository
@Transactional
public class LibroAutorRepoImpl implements ILibroAutorRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro2Autor2 libroautor) {
		this.entityManager.persist(libroautor);
	}

}
