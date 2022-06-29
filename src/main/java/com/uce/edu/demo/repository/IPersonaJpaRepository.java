package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	public Persona buscarPorId(Integer id);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);
}
