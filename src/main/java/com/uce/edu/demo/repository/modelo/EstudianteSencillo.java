package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String apellido;
	private String nombre;
	private String carrera;

	public EstudianteSencillo() {
	}

	public EstudianteSencillo(String apellido, String nombre, String carrera) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "EstudianteSencillo [apellido=" + apellido + ", nombre=" + nombre + ", carrera=" + carrera + "]";
	}

	// SET y GET
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}
