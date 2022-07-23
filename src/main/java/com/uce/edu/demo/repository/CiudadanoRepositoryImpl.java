package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		this.entityManager.persist(ciudadano);
	}

	@Override
	public int actualizar(String cedula, String nombre) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE Ciudadano c SET c.nombre = :datoNombre WHERE c.cedula = :datoCedula");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

	@Override
	public int eliminar(String cedula) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Ciudadano c WHERE c.cedula = :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

	@Override
	public Ciudadano buscar(String cedula) {
		TypedQuery<Ciudadano> miTypedQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c WHERE c.cedula = :datoCedula", Ciudadano.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

}
