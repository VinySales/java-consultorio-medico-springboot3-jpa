package com.hospital.janiele.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String nome;
	String crm;
	
	@ManyToMany
    @JoinTable(
        name = "medico_especialidade",
        joinColumns = @JoinColumn(name = "medico_id"),
        inverseJoinColumns = @JoinColumn(name = "especialidade_id")
    )
	private List<Especialidade> especialidades;
	
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;
	
    public Medico() {
    }
    
	public Medico(Long id, String nome, String crm, List<Especialidade> especialidades) {
		super();
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.especialidades = especialidades;
	}

	public Medico(Object id2, String nome2, String crm2, List<Especialidade> asList) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCrm() {
		return crm;
	}
	
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public List<Especialidade> getEspecialidade() {
		return especialidades;
	}

	public void setEspecialidade(List<Especialidade> especialidade) {
		this.especialidades = especialidade;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crm, especialidades, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(crm, other.crm) && Objects.equals(especialidades, other.especialidades)
				&& Objects.equals(nome, other.nome);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
