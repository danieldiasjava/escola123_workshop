package com.escola123.workshoppostgresql.domain;

import java.io.Serializable;
import java.util.Objects;

import com.escola123.workshoppostgresql.domain.pk.CursoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;


@Entity(name="tb_curso")
public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private CursoPK id;
	
	
	private String name;
	private String sigla;
	
	public Curso() {
	}

	public Curso(Alunos alunos, Turma turma, String name, String sigla) {
		super();
		id.setAlunos(alunos);
		id.setTurma(turma);
		this.name = name;
		this.sigla = sigla;
	}

	public Alunos getAlunos() {
		return id.getAlunos();
	}
	
	public void setAlunos(Alunos alunos) {
		id.setAlunos(alunos);
	}
	
	public Turma getTurma() {
		return id.getTurma();
	}
	
	public void setTurma(Turma turma) {
		id.setTurma(turma);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}



}
