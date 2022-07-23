package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

public interface ICiudadanoRepository {

	public void insertar(Ciudadano ciudadano);

	public int actualizar(String cedula, String nombre);

	public int eliminar(String cedula);

	public Ciudadano buscar(String cedula);
}
