package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPasajeroRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Pasajero;

@Service
public class PasajeroServiceImpl implements IPasajeroService {

	@Autowired
	private IPasajeroRepository pasajeroRepository;

	@Override
	public void insertar(Pasajero pasajero) {
		this.pasajeroRepository.insertar(pasajero);
	}

	@Override
	public int actualizar(String cedula, String nombre) {
		return this.pasajeroRepository.actualizar(cedula, nombre);
	}

	@Override
	public int eliminar(String cedula) {
		return this.pasajeroRepository.eliminar(cedula);
	}

	@Override
	public Pasajero buscar(String cedula) {
		return this.pasajeroRepository.buscar(cedula);
	}

}
