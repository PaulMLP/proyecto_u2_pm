package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {
	
	public List<Persona> buscarPorGenero(String genero);

	public List<Persona> buscarPorApellido(String apellido);
	
	public Persona buscarPorCedula(String cedula);
	
	public Persona buscarPorId(Integer id);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);
	
}
