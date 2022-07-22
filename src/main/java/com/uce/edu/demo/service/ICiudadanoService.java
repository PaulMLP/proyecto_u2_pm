package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Ciudadano;

public interface ICiudadanoService {

	public void insertar(Ciudadano ciudadano);

	public int actualizar(String cedula, String nombre);

	public int eliminar(String cedula);

	public Ciudadano buscar(String cedula);

}
