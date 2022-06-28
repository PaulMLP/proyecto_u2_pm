package com.uce.edu.demo.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU2PmApplication;
import com.uce.edu.demo.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.to.Estudiante;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{

	@Autowired
	private IEstudianteJdbcRepository iEstudianteJdbcRepository;
	
	private static Logger LOG = Logger.getLogger(ProyectoU2PmApplication.class);
	
	@Override
	public Estudiante buscarEstudiante(int id) {
		return this.iEstudianteJdbcRepository.buscarEstudiante(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		LOG.debug("Se inserta el estudiante: "+estudiante);
		this.iEstudianteJdbcRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		LOG.debug("Se actualiza el estudiante: "+estudiante);
		this.iEstudianteJdbcRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(int id) {
		LOG.debug("Se eliminar el estudiante con id: "+id);
		this.iEstudianteJdbcRepository.eliminar(id);
	}

}
