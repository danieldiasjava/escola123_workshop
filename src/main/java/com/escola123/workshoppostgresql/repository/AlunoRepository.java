package com.escola123.workshoppostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola123.workshoppostgresql.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{



}

