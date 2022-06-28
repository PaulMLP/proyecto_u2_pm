package com.uce.edu.demo.service;

import com.uce.edu.demo.to.Estudiante;

public interface IEstudianteJdbcService {
	public Estudiante buscarEstudiante(int id);

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(int id);
}
