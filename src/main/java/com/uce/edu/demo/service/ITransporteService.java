package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Transporte;

public interface ITransporteService {
	public void insertar(Transporte ciudadano);

	public int actualizar(String placa, String cooperativa);

	public int eliminar(String placa);

	public Transporte buscar(String nombre);
}
