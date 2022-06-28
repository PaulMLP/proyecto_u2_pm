package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.Persona;

public interface IPersonaJdbcRepository {

	public Persona buscarPersona(int id);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(int id);
}
