package com.uce.edu.demo.service;

import com.uce.edu.demo.to.EstudianteTo;

public interface IEstudianteJdbcService {
	public EstudianteTo buscarEstudiante(int id);

	public void guardar(EstudianteTo estudiante);

	public void actualizar(EstudianteTo estudiante);

	public void eliminar(int id);
}
