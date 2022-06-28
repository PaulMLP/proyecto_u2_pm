package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.Estudiante;

public interface IEstudianteJdbcRepository {

	public Estudiante buscarEstudiante(int id);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(int id);
}
