package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Transporte;

public interface ITransporteRepository {

	public void insertar(Transporte transporte);

	public int actualizar(String placa, String cooperativa);

	public int eliminar(String placa);

	public Transporte buscar(String nombre);
}
