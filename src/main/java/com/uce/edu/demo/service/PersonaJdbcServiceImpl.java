package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.PersonaTo;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService{

	@Autowired
	private IPersonaJdbcRepository personaJdbcRepository;
	
	@Override
	public PersonaTo buscarPersona(int id) {
		return this.personaJdbcRepository.buscarPersona(id);
	}

	@Override
	public void guardar(PersonaTo persona) {
		this.personaJdbcRepository.insertar(persona);
	}

	@Override
	public void actualizar(PersonaTo persona) {
		this.personaJdbcRepository.actualizar(persona);
	}

	@Override
	public void eliminar(int id) {
		this.personaJdbcRepository.eliminar(id);
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		return this.personaJdbcRepository.buscarTodos();
	}
	
}
