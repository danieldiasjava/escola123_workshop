
package com.escola123.workshoppostgresql.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Curso;
import com.escola123.workshoppostgresql.repository.CursoRepository;
import com.escola123.workshoppostgresql.services.exception.ObjectNotFoundException;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	public Curso findById(Long id) {
		Optional<Curso> obj = cursoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id nao encontrado"));

	}

	public Curso insert(Curso cursoObj) {
		return cursoRepository.save(cursoObj);
	}

	public void delete(Long id) {
		findById(id);
		cursoRepository.deleteById(id);
	}

	public Curso update(Long id, Curso obj) {
		Curso entity = cursoRepository.getReferenceById(id);
		updateData(entity, obj);
		return cursoRepository.save(entity);
	}

	private void updateData(Curso entity, Curso obj) {
		entity.setName(obj.getName());
		entity.setSigla(obj.getSigla());

	}

}
