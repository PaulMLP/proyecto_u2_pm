package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro2;

@Repository
@Transactional
public class Libro2RepositoryImpl implements ILibro2Repository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro2 libro) {
		this.entityManager.persist(libro);
	}

}
