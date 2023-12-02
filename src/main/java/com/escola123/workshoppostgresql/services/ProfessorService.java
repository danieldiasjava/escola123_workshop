package com.escola123.workshoppostgresql.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Professor;
import com.escola123.workshoppostgresql.repository.ProfessorRepository;
import com.escola123.workshoppostgresql.services.exception.ObjectNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	public Professor findById(Long id) {
		Optional<Professor> obj = professorRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id nao encontrado"));

	}

	public Professor insert(Professor profObj) {

		return professorRepository.save(profObj);
	}

	public void delete(Long id) {
		findById(id);
		professorRepository.deleteById(id);
	}

	public Professor update(Long id, Professor obj) {
		Professor entity = professorRepository.getReferenceById(id);
		updateData(entity, obj);
		return professorRepository.save(entity);
	}

	private void updateData(Professor entity, Professor obj) {
		entity.setName(obj.getName());
		entity.setAddress(obj.getAddress());

	}

}
