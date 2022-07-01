package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.EstudianteTo;

public interface IEstudianteJdbcRepository {

	public EstudianteTo buscarEstudiante(int id);

	public void insertar(EstudianteTo estudiante);

	public void actualizar(EstudianteTo estudiante);

	public void eliminar(int id);
}
