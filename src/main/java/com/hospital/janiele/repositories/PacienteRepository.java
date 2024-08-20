package com.hospital.janiele.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.janiele.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
}
