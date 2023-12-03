package com.escola123.workshoppostgresql.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name="tb_turma")
public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer semestre;
	private Integer ano;
	
	
	@ManyToMany
	@JoinTable(name = "tb_aluno_turma", joinColumns = @JoinColumn(name="turma_id"), 
	inverseJoinColumns = @JoinColumn(name="aluno_id"))
	private Set<Aluno> alunos = new HashSet<>();
	
	@ManyToMany(mappedBy = "turmas")
	public Set<Professor> professores = new HashSet<>();
	
	
	public Turma() {
	
	}

	public Turma(Long id, Integer semestre, Integer ano) {
		super();
		this.id = id;
		this.semestre = semestre;
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(id, other.id);
	}

	
}
