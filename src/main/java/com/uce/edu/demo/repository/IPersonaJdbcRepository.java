package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.to.PersonaTo;

public interface IPersonaJdbcRepository {

	public List<PersonaTo> buscarTodos();

	public PersonaTo buscarPersona(int id);

	public void insertar(PersonaTo persona);

	public void actualizar(PersonaTo persona);

	public void eliminar(int id);
}
