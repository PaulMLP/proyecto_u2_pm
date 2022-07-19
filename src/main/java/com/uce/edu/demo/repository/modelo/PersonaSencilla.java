package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class PersonaSencilla implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;

	public PersonaSencilla() {
	}

	public PersonaSencilla(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "PersonaSencilla [nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	// SET y GET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

}
