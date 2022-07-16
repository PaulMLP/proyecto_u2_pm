package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {
	public List<Persona> buscarPorNombre(String nombre);

	public List<Persona> buscarPorGenero(String genero);

	public List<Persona> buscarPorApelldio(String apellido);

	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);
	
	public Persona buscarPorCedula(String cedula);
	

	public Persona buscarPorCedulaTyped(String cedula);

	public Persona buscarPorCedulaNamed(String cedula);

	public Persona buscarPorCedulaTypedNamed(String cedula);
	
	
	public Persona buscarPorCedulaNative(String cedula);
	
	public Persona buscarPorCedulaNamedNative(String cedula);
	
	
	public Persona buscarPorCedulaCriteria(String cedula);
	
	public Persona buscarDinamicamente(String nombre, String apellido, String genero);
	
	
	public Persona buscarPorId(Integer id);

	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);

	public int actualizarPorApellido(String genero, String apellido);

	public int eliminarPorGenero(String genero);
}
