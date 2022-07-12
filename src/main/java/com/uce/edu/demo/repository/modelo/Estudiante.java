package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Estudiante.buscarPorEdadGenero", query = "SELECT e FROM Estudiante e WHERE e.edad >= :datoEdad and e.genero = :datoGenero ORDER BY e.apellido ASC")
@NamedQuery(name = "Estudiante.buscarPorCarreraSemestre", query = "SELECT e FROM Estudiante e WHERE e.carrera = :datoCarrera and e.semestre = :datoSemestre ORDER BY e.nombre DESC")
@NamedQuery(name = "Estudiante.buscarPorSemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :datoSemestre")
@NamedQuery(name = "Estudiante.buscarPorEdad", query = "SELECT e FROM Estudiante e WHERE e.edad = :datoEdad")
public class Estudiante {

	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_seq_id")
	@SequenceGenerator(name = "estu_seq_id", sequenceName = "estu_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "estu_cedula")
	private String cedula;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_carrera")
	private String carrera;

	@Column(name = "estu_semestre")
	private Integer semestre;

	@Column(name = "estu_edad")
	private Integer edad;

	@Column(name = "estu_genero")
	private String genero;

	
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", carrera=" + carrera + ", semestre=" + semestre + ", edad=" + edad + ", genero=" + genero + "]";
	}

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
