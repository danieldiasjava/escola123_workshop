package com.escola123.workshoppostgresql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Alunos;
import com.escola123.workshoppostgresql.repository.AlunosRepository;

@Service
public class AlunosService {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	public List<Alunos> findAll(){
		return alunosRepository.findAll();
	}

}
