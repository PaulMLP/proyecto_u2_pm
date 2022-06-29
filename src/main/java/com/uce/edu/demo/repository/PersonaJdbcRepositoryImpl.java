package com.uce.edu.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.PersonaTo;

@Repository
public class PersonaJdbcRepositoryImpl implements IPersonaJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PersonaTo buscarPersona(int id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM persona WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<PersonaTo>(PersonaTo.class));
	}

	@Override
	public void insertar(PersonaTo persona) {
		this.jdbcTemplate.update("INSERT INTO persona(id, nombre, apellido) VALUES (?, ?, ?)",
				new Object[] { persona.getId(), persona.getNombre(), persona.getApellido() });
	}

	@Override
	public void actualizar(PersonaTo persona) {
		this.jdbcTemplate.update("UPDATE persona SET nombre=?, apellido=? WHERE id=?",
				new Object[] { persona.getNombre(), persona.getApellido(), persona.getId() });
	}

	@Override
	public void eliminar(int id) {
		this.jdbcTemplate.update("DELETE FROM persona WHERE id=?", new Object[] { id });
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		return this.jdbcTemplate.query("SELECT * FROM persona", new PersonaRowMapper());
	}

	class PersonaRowMapper implements RowMapper<PersonaTo> {

		@Override
		public PersonaTo mapRow(ResultSet rs, int rowNum) throws SQLException {
			PersonaTo persona = new PersonaTo();
			persona.setId(rs.getInt("id"));
			persona.setNombre(rs.getString("nombre"));
			persona.setApellido(rs.getString("apellido"));
			return persona;
		}
	}
}
