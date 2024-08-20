package com.hospital.janiele.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String nome;
	String cpf;
	Integer numeroCarteirinha;
	Instant dataDeNascimento;
	
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;
	
	public Paciente() {
	}
			
	public Paciente(Long id, String nome, String cpf, Integer numeroCarteirinha, Instant dataDeNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.numeroCarteirinha = numeroCarteirinha;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getNumeroCarteirinha() {
		return numeroCarteirinha;
	}

	public void setNumeroCarteirinha(Integer numeroCarteirinha) {
		this.numeroCarteirinha = numeroCarteirinha;
	}

	public Instant getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Instant dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataDeNascimento, nome, numeroCarteirinha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataDeNascimento, other.dataDeNascimento)
				&& Objects.equals(nome, other.nome) && Objects.equals(numeroCarteirinha, other.numeroCarteirinha);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
