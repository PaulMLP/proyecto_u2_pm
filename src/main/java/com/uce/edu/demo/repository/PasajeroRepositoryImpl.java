package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Pasajero;

@Repository
@Transactional
public class PasajeroRepositoryImpl implements IPasajeroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Pasajero pasajero) {
		this.entityManager.persist(pasajero);
	}

	@Override
	public int actualizar(String cedula, String nombre) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE Pasajero p SET p.nombre = :datoNombre WHERE p.cedula = :datoCedula");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

	@Override
	public int eliminar(String cedula) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Pasajero p WHERE p.cedula = :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

	@Override
	public Pasajero buscar(String cedula) {
		TypedQuery<Pasajero> miTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Pasajero p WHERE p.cedula = :datoCedula", Pasajero.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

}
