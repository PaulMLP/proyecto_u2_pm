package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {
	
	public Persona buscarPorId(Integer id);

	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);
	
}
