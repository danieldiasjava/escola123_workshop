package com.escola123.workshoppostgresql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Turma;
import com.escola123.workshoppostgresql.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public List<Turma> findAll() {
		return turmaRepository.findAll();
	}

	public Turma insert(Turma turmaObj) {

		return turmaRepository.save(turmaObj);
	}

}
