package com.uce.edu.demo.repository.modelo.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transporte")
public class Transporte {

	@Id
	@Column(name = "tran_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_seq_id")
	@SequenceGenerator(name = "tran_seq_id", sequenceName = "tran_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "tran_placa")
	private String placa;

	@Column(name = "tran_nombre")
	private String nombre;

	@Column(name = "tran_cooperativa")
	private String cooperativa;

	@OneToMany(mappedBy = "transporte")
	private List<Pasajero> pasajeros;

	@Override
	public String toString() {
		return "Transporte [id=" + id + ", placa=" + placa + ", nombre=" + nombre + ", cooperativa=" + cooperativa
				+ "]";
	}

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCooperativa() {
		return cooperativa;
	}

	public void setCooperativa(String cooperativa) {
		this.cooperativa = cooperativa;
	}

	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

}
