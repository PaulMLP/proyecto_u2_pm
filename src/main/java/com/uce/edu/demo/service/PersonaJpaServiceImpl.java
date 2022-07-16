package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {

	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository;

	@Override
	public Persona buscarPorId(Integer id) {
		return this.iPersonaJpaRepository.buscarPorId(id);
	}

	@Override
	public void guardar(Persona persona) {
		this.iPersonaJpaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		this.iPersonaJpaRepository.actualizar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		this.iPersonaJpaRepository.eliminar(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedula(cedula);
	}

	// Query JPQL
	// Typed
	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaTyped(cedula);
	}

	// Named
	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaNamed(cedula);
	}

	// Typed - Named
	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaTypedNamed(cedula);
	}

	// Native
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaNative(cedula);
	}

	// Native Named
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaNamedNative(cedula);
	}

	// Criteria
	@Override
	public Persona buscarPorCedulaCriteria(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaCriteria(cedula);
	}


	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		return this.iPersonaJpaRepository.buscarDinamicamente(nombre, apellido, genero);
	}

	
	
	@Override
	public List<Persona> buscarPorGenero(String genero) {
		return this.iPersonaJpaRepository.buscarPorGenero(genero);
	}

	@Override
	public List<Persona> buscarPorApelldio(String apellido) {
		return this.iPersonaJpaRepository.buscarPorApellido(apellido);
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		return this.iPersonaJpaRepository.buscarPorNombre(nombre);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		return this.iPersonaJpaRepository.actualizarPorApellido(genero, apellido);
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		return this.iPersonaJpaRepository.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		return this.iPersonaJpaRepository.eliminarPorGenero(genero);
	}

}
