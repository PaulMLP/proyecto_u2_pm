package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.EstudianteTo;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EstudianteTo buscarEstudiante(int id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM estudiante WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
	}

	@Override
	public void insertar(EstudianteTo estudiante) {
		this.jdbcTemplate.update(
				"INSERT INTO estudiante(id, nombre, apellido, carrera, semestre) VALUES (?, ?, ?, ?, ?)",
				new Object[] { estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getCarrera(), estudiante.getSemestre() });
	}

	@Override
	public void actualizar(EstudianteTo estudiante) {
		this.jdbcTemplate.update("UPDATE estudiante SET nombre=?, apellido=?, carrera=?, semestre=? WHERE id=?",
				new Object[] { estudiante.getNombre(), estudiante.getApellido(), estudiante.getCarrera(),
						estudiante.getSemestre(), estudiante.getId() });
	}

	@Override
	public void eliminar(int id) {
		this.jdbcTemplate.update("DELETE FROM estudiante WHERE id=?", new Object[] { id });
	}

}
