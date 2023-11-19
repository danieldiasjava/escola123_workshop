package com.escola123.workshoppostgresql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Professores;
import com.escola123.workshoppostgresql.repository.ProfessoresRepository;

@Service
public class ProfessoresService {
	
	@Autowired
	private ProfessoresRepository professoresRepository;
	
	public List<Professores> findAll(){
		return professoresRepository.findAll();
	}

	public Professores insert(Professores profObj) {
	
		return professoresRepository.save(profObj);
	}

}
