package com.hospital.janiele.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospital.janiele.entities.Consulta;
import com.hospital.janiele.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	
	private ConsultaRepository repository;
	
	public List<Consulta> findAll() {
		return repository.findAll();
	}

	public Consulta findById(Long id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.get();
	}
	
	public Consulta insert(Consulta obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Consulta consulta = findById(id);
		repository.delete(consulta);
	}
}
