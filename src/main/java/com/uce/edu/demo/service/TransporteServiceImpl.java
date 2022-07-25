package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ITransporteRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Transporte;

@Service
public class TransporteServiceImpl implements ITransporteService {

	@Autowired
	private ITransporteRepository transporteRepository;

	@Override
	public void insertar(Transporte transporte) {
		this.transporteRepository.insertar(transporte);
	}

	@Override
	public int actualizar(String placa, String cooperativa) {
		return this.transporteRepository.actualizar(placa, cooperativa);
	}

	@Override
	public int eliminar(String placa) {
		return this.transporteRepository.eliminar(placa);
	}

	@Override
	public Transporte buscar(String nombre) {
		return this.transporteRepository.buscar(nombre);
	}

}
