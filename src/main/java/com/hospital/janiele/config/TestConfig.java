package com.hospital.janiele.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hospital.janiele.entities.Especialidade;
import com.hospital.janiele.entities.Medico;
import com.hospital.janiele.entities.Paciente;
import com.hospital.janiele.repositories.ConsultaRepository;
import com.hospital.janiele.repositories.EspecialidadeRepository;
import com.hospital.janiele.repositories.MedicoRepository;
import com.hospital.janiele.repositories.PacienteRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public void run(String... args) throws Exception {

		Especialidade e1 = new Especialidade(null, "Pediatra");
		Especialidade e2 = new Especialidade(null, "Oftalmo");
		Especialidade e3 = new Especialidade(null, "Psicólogo");
		Especialidade e4 = new Especialidade(null, "Psiquiatra");
		Especialidade e5 = new Especialidade(null, "Dentista");
		
		Medico m1 = new Medico(null, "Janiele", "CRM-123456789", Arrays.asList(e3,e4));
		Medico m2 = new Medico(null, "Jamile", "CRM-123456789", Arrays.asList(e5));
		Medico m3 = new Medico(null, "Jailane", "CRM-123456789", Arrays.asList(e5));

		Paciente p1 = new Paciente(null, "Vinicius", "38233854883", 123456789, Instant.parse("2000-01-27T23:00:07Z"));
		Paciente p2 = new Paciente(null, "Mika", "9087345982", 987654321, Instant.parse("2002-10-28T12:00:07Z"));
		
		
		especialidadeRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5));
		medicoRepository.saveAll(Arrays.asList(m1,m2,m3));
		pacienteRepository.saveAll(Arrays.asList(p1,p2));
	}
}
