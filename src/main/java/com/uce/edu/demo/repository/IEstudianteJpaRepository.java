package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public Estudiante buscarPorCedula(String cedula);

	public List<Estudiante> buscarPorApellidoGenero(String apellido, String genero);

	public List<Estudiante> buscarPorEdadGenero(Integer edad, String genero);

	public List<Estudiante> buscarPorCarreraSemestre(String carrera, Integer semestre);

	public List<Estudiante> buscarPorSemestre(Integer semestre);

	public List<Estudiante> buscarPorEdad(Integer edad);
	

	public Estudiante buscarPorCedulaNative(String cedula);

	public List<Estudiante> buscarPorSemestreCarreraNative(Integer semestre, String carrera);

	
	public List<Estudiante> buscarPorApellidoNombreNamedNative(String apellido, String nombre);
	
	public List<Estudiante> buscarPorGeneroEdadNamedNative(String genero, Integer edad);
	
	
	public Estudiante buscarPorCedulaCriteria(String cedula);
	
	public Estudiante buscarPorGeneroCriteria(String genero);

}
