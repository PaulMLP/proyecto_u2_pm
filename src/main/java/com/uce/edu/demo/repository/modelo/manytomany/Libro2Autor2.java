package com.uce.edu.demo.repository.modelo.manytomany;

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
@Table(name = "libro2_autor2")
public class Libro2Autor2 {

	@Id
	@Column(name = "liau2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liau2_seq_id")
	@SequenceGenerator(name = "liau2_seq_id", sequenceName = "liau2_seq_id", allocationSize = 1)
	private Integer id;
	
//	@Column(name = "liau_autor_id")
//	private Integer autorId;
//
//	@Column(name = "liau_libro_id")
//	private Integer libroId;

	@ManyToOne
	@JoinColumn(name = "libro_id")
	private Libro2 libro2;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor2 autor2;
	

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Libro2 getLibro2() {
		return libro2;
	}

	public void setLibro2(Libro2 libro2) {
		this.libro2 = libro2;
	}

	public Autor2 getAutor2() {
		return autor2;
	}

	public void setAutor2(Autor2 autor2) {
		this.autor2 = autor2;
	}

	
}
