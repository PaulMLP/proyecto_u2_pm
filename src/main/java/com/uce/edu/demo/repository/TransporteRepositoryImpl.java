package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Transporte;

@Repository
@Transactional
public class TransporteRepositoryImpl implements ITransporteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Transporte transporte) {
		this.entityManager.persist(transporte);
	}

	@Override
	public int actualizar(String placa, String cooperativa) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE Transporte t SET t.cooperativa = :datoCooperativa WHERE t.placa = :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);
		myQuery.setParameter("datoCooperativa", cooperativa);
		return myQuery.executeUpdate();
	}

	@Override
	public int eliminar(String placa) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Transporte t WHERE t.placa = :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);
		return myQuery.executeUpdate();
	}

	@Override
	public Transporte buscar(String nombre) {
		TypedQuery<Transporte> miTypedQuery = this.entityManager
				.createQuery("SELECT t FROM Transporte t WHERE t.nombre = :datoNombre", Transporte.class);
		miTypedQuery.setParameter("datoNombre", nombre);
		return miTypedQuery.getSingleResult();
	}

}
