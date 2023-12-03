package com.escola123.workshoppostgresql.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Turma;
import com.escola123.workshoppostgresql.repository.TurmaRepository;
import com.escola123.workshoppostgresql.services.exception.ObjectNotFoundException;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public List<Turma> findAll() {
		return turmaRepository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional<Turma> obj = turmaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id nao encontrado"));

	}

	public Turma insert(Turma turmaObj) {

		return turmaRepository.save(turmaObj);
	}
	
	public void delete(Long id) {
		findById(id);
		turmaRepository.deleteById(id);
	}

	public Turma update(Long id, Turma obj) {
		Turma entity = turmaRepository.getReferenceById(id);
		updateData(entity, obj);
		return turmaRepository.save(entity);
	}

	private void updateData(Turma entity, Turma obj) {
		entity.setSemestre(obj.getSemestre());
		entity.setAno(obj.getAno());

	}

}
