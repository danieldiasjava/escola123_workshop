package com.escola123.workshoppostgresql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Professor;
import com.escola123.workshoppostgresql.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> findAll(){
		return professorRepository.findAll();
	}

	public Professor insert(Professor profObj) {
	
		return professorRepository.save(profObj);
	}

}
