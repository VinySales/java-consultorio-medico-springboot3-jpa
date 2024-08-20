package com.hospital.janiele.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospital.janiele.entities.Medico;
import com.hospital.janiele.repositories.MedicoRepository;

@Service
public class MedicoService {
	private MedicoRepository repository;

	public List<Medico> findAll() {
		return repository.findAll();
	}

	public Medico findById(Long id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.get();
	}

	public Medico insert(Medico obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		Medico medico = findById(id);
		repository.delete(medico);
	}
}
