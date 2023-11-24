package com.escola123.workshoppostgresql.domain.pk;

import java.io.Serializable;
import java.util.Objects;

import com.escola123.workshoppostgresql.domain.Alunos;
import com.escola123.workshoppostgresql.domain.Turma;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CursoPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "alunos_id")
	private Alunos alunos;
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	
	public Alunos getAlunos() {
		return alunos;
	}
	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(alunos, turma);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoPK other = (CursoPK) obj;
		return Objects.equals(alunos, other.alunos) && Objects.equals(turma, other.turma);
	}
	
	

}
