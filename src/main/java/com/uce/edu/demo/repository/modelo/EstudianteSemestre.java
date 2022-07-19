package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class EstudianteSemestre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String carrera;
	private Integer edad;
	
	public EstudianteSemestre() {
	}

	public EstudianteSemestre(String carrera, Integer edad) {
		super();
		this.carrera = carrera;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "EstudianteSemestre [carrera=" + carrera + ", edad=" + edad + "]";
	}

	// SET y GET
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
