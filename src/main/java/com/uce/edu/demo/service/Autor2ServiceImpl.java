package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IAutor2Repository;
import com.uce.edu.demo.repository.modelo.manytomany.Autor2;

@Service
public class Autor2ServiceImpl implements IAutor2Service {

	@Autowired
	private IAutor2Repository autor2Repository;

	@Override
	public void insertar(Autor2 autor) {
		this.autor2Repository.insertar(autor);
	}

}
