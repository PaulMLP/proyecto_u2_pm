package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;

	@Override
	public void guardar(Estudiante estudiante) {
		this.iEstudianteJpaRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.iEstudianteJpaRepository.actualizar(estudiante);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		return this.iEstudianteJpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public List<Estudiante> buscarPorApellidoGenero(String apellido, String genero) {
		return this.iEstudianteJpaRepository.buscarPorApellidoGenero(apellido, genero);
	}

	@Override
	public List<Estudiante> buscarPorEdadGenero(Integer edad, String genero) {
		return this.iEstudianteJpaRepository.buscarPorEdadGenero(edad, genero);
	}

	@Override
	public List<Estudiante> buscarPorCarreraSemestre(String carrera, Integer semestre) {
		return this.iEstudianteJpaRepository.buscarPorCarreraSemestre(carrera, semestre);
	}

	@Override
	public List<Estudiante> buscarPorSemestre(Integer semestre) {
		return this.iEstudianteJpaRepository.buscarPorSemestre(semestre);
	}

	@Override
	public List<Estudiante> buscarPorEdad(Integer edad) {
		return this.iEstudianteJpaRepository.buscarPorEdad(edad);
	}

	
	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		return this.iEstudianteJpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public List<Estudiante> buscarPorSemestreCarreraNative(Integer semestre, String carrera) {
		return this.iEstudianteJpaRepository.buscarPorSemestreCarreraNative(semestre, carrera);
	}

	@Override
	public List<Estudiante> buscarPorApellidoNombreNamedNative(String apellido, String nombre) {
		return this.iEstudianteJpaRepository.buscarPorApellidoNombreNamedNative(apellido, nombre);
	}

	@Override
	public List<Estudiante> buscarPorGeneroEdadNamedNative(String genero, Integer edad) {
		return this.iEstudianteJpaRepository.buscarPorGeneroEdadNamedNative(genero, edad);
	}

}
