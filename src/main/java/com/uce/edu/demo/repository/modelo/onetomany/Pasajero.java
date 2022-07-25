package com.uce.edu.demo.repository.modelo.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pasajero")
public class Pasajero {

	@Id
	@Column(name = "pasj_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pasj_seq_id")
	@SequenceGenerator(name = "pasj_seq_id", sequenceName = "pasj_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "pasj_cedula")
	private String cedula;

	@Column(name = "pasj_nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "pasj_id_transporte")
	private Transporte transporte;

	@Override
	public String toString() {
		return "Pasajero [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + "]";
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

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

}
