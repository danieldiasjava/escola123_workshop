
package com.escola123.workshoppostgresql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola123.workshoppostgresql.domain.Curso;
import com.escola123.workshoppostgresql.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	
	public Curso insert(Curso cursoObj) {
		return cursoRepository.save(cursoObj);
	}

}
