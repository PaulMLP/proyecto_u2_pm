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
@Table(name = "libro2")
public class Libro2 {

	@Id
	@Column(name = "libr2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr2_seq_id")
	@SequenceGenerator(name = "libr2_seq_id", sequenceName = "libr2_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "libr2_titulo")
	private String titulo;

	@Column(name = "libr2_cantidad_paginas")
	private Integer cantidadPaginas;

	@OneToMany(mappedBy = "libro2")
	private Set<Libro2Autor2> autor_libro;

	
	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public Set<Libro2Autor2> getAutor_libro() {
		return autor_libro;
	}

	public void setAutor_libro(Set<Libro2Autor2> autor_libro) {
		this.autor_libro = autor_libro;
	}
	

}
