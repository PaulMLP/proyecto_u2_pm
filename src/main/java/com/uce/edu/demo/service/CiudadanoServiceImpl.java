package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoRepository;
import com.uce.edu.demo.repository.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;

	@Override
	public void insertar(Ciudadano ciudadano) {
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public int actualizar(String cedula, String nombre) {
		return this.ciudadanoRepository.actualizar(cedula, nombre);
	}

	@Override
	public int eliminar(String cedula) {
		return this.ciudadanoRepository.eliminar(cedula);
	}

	@Override
	public Ciudadano buscar(String cedula) {
		return this.ciudadanoRepository.buscar(cedula);
	}

}
