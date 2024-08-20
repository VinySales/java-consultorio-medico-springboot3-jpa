package com.hospital.janiele.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospital.janiele.entities.Paciente;
import com.hospital.janiele.repositories.PacienteRepository;

@Service
public class PacienteService {
	
	private PacienteRepository repository;
	
	public List<Paciente> findAll() {
		return repository.findAll();
	}

	public Paciente findById(Long id) {
		Optional<Paciente> obj = repository.findById(id);
		return obj.get();
	}
	
	public Paciente insert(Paciente obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Paciente paciente = findById(id);
		repository.delete(paciente);
	}
}
