package com.escola123.workshoppostgresql.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Aluno;
import com.escola123.workshoppostgresql.repository.AlunoRepository;
import com.escola123.workshoppostgresql.services.exception.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Aluno findById(Long id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id nao encontrado"));

	}

	public Aluno insert(Aluno alunosObj) {

		return alunoRepository.save(alunosObj);
	}

	public void delete(Long id) {
		findById(id);
		alunoRepository.deleteById(id);
	}

	public Aluno update(Long id, Aluno obj) {
		Aluno entity = alunoRepository.getReferenceById(id);
		updateData(entity, obj);
		return alunoRepository.save(entity);
	}

	private void updateData(Aluno entity, Aluno obj) {
		entity.setName(obj.getName());
		entity.setAddress(obj.getAddress());

	}

}
