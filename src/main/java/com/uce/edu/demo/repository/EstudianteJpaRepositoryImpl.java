package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.EstudianteSemestre;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		TypedQuery<Estudiante> miTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula ORDER BY e.edad", Estudiante.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorApellidoGenero(String apellido, String genero) {
		TypedQuery<Estudiante> miTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido and e.genero = :datoGenero",
				Estudiante.class);
		miTypedQuery.setParameter("datoApellido", apellido);
		miTypedQuery.setParameter("datoGenero", genero);
		return miTypedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadGenero(Integer edad, String genero) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdadGenero",
				Estudiante.class);
		myQuery.setParameter("datoEdad", edad);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorCarreraSemestre(String carrera, Integer semestre) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCarreraSemestre",
				Estudiante.class);
		myQuery.setParameter("datoCarrera", carrera);
		myQuery.setParameter("datoSemestre", semestre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorSemestre(Integer semestre) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestre");
		myQuery.setParameter("datoSemestre", semestre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdad(Integer edad) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdad");
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_cedula = :datoCedula",
				Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorSemestreCarreraNative(Integer semestre, String carrera) {
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE estu_semestre = :datoSemestre AND estu_carrera = :datoCarrera",
				Estudiante.class);
		myQuery.setParameter("datoSemestre", semestre);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoNombreNamedNative(String apellido, String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoNombreNative",
				Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorGeneroEdadNamedNative(String genero, Integer edad) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorGeneroEdadNative",
				Estudiante.class);
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	// Criteria
	@Override
	public Estudiante buscarPorCedulaCriteria(String cedula) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		// Especificamos el retorno de mi SQL
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);

		// Aqui empezamos a construir el SQL
		// Root FROM
		Root<Estudiante> estudianteRoot = myQuery.from(Estudiante.class); // FROM Persona

		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(
				myQuery.select(estudianteRoot).where(myBuilder.equal(estudianteRoot.get("cedula"), cedula)));

		return myQueryFinal.getSingleResult();
	}

	@Override
	public Estudiante buscarPorGeneroCriteria(String genero) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);

		myQuery.select(myTabla).where(predicadoGenero).orderBy(myCriteria.asc(myTabla.get("edad")));
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<EstudianteSencillo> buscarSencillo(String apellido) {
		TypedQuery<EstudianteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.EstudianteSencillo(e.nombre, e.apellido, e.carrera) FROM Estudiante e WHERE e.apellido = :datoApellido GROUP BY e.nombre, e.apellido, e.carrera",
				EstudianteSencillo.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteSemestre> consultarEstudiantesCarrera(String carrera) {
		TypedQuery<EstudianteSemestre> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.EstudianteSemestre(e.carrera, e.edad) FROM Estudiante e WHERE e.carrera = :datoCarrera GROUP BY e.carrera, e.edad ORDER BY e.edad",
				EstudianteSemestre.class);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}
}
