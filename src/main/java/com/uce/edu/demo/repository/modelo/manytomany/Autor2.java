package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor2")
public class Autor2 {

	@Id
	@Column(name = "auto2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto2_seq_id")
	@SequenceGenerator(name = "auto2_seq_id", sequenceName = "auto2_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "auto2_nombre")
	private String nombre;

	@OneToMany(mappedBy = "autor2")
	private Set<Libro2Autor2> libro_autor;

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro2Autor2> getLibro_autor() {
		return libro_autor;
	}

	public void setLibro_autor(Set<Libro2Autor2> libro_autor) {
		this.libro_autor = libro_autor;
	}

}
