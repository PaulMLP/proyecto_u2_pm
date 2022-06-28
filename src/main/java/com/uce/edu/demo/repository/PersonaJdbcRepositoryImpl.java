package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.Persona;

@Repository
public class PersonaJdbcRepositoryImpl implements IPersonaJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Persona buscarPersona(int id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM persona WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	@Override
	public void insertar(Persona persona) {
		this.jdbcTemplate.update("INSERT INTO persona(id, nombre, apellido) VALUES (?, ?, ?)",
				new Object[] { persona.getId(), persona.getNombre(), persona.getApellido() });
	}

	@Override
	public void actualizar(Persona persona) {
		this.jdbcTemplate.update("UPDATE persona SET nombre=?, apellido=? WHERE id=?",
				new Object[] { persona.getNombre(), persona.getApellido(), persona.getId() });
	}

	@Override
	public void eliminar(int id) {
		this.jdbcTemplate.update("DELETE FROM persona WHERE id=?", new Object[] { id });
	}

}
