package com.hospital.janiele.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospital.janiele.entities.Especialidade;
import com.hospital.janiele.repositories.EspecialidadeRepository;

@Service
public class EspecialidadeService {
	private EspecialidadeRepository repository;
	
	public List<Especialidade> findAll() {
		return repository.findAll();
	}

	public Especialidade findById(Long id) {
		Optional<Especialidade> obj = repository.findById(id);
		return obj.get();
	}
	
	public Especialidade insert(Especialidade obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Especialidade especialidade = findById(id);
		repository.delete(especialidade);
	}
}
