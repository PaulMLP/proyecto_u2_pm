package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	
	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);
	
	
	public Estudiante buscarPorCedula(String cedula);
	
	public List<Estudiante> buscarPorApellidoGenero(String apellido, String genero);

	
	public List<Estudiante> buscarPorEdadGenero(Integer edad, String genero);
	
	public List<Estudiante> buscarPorCarreraSemestre(String carrera, Integer semestre);
	
	
	public List<Estudiante> buscarPorSemestre(Integer semestre);
	
	public List<Estudiante> buscarPorEdad(Integer edad);
}
