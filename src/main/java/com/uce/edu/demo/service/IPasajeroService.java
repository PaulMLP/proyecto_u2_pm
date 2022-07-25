package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Pasajero;

public interface IPasajeroService {
	public void insertar(Pasajero pasajero);

	public int actualizar(String cedula, String nombre);

	public int eliminar(String cedula);

	public Pasajero buscar(String cedula);
}
