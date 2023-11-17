package com.escola123.workshoppostgresql.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola123.workshoppostgresql.domain.Alunos;
import com.escola123.workshoppostgresql.services.AlunosService;


@RestController
@RequestMapping(value="/alunos")
public class AlunosResources {
	
	@Autowired
	private AlunosService service;
	
	@GetMapping
	public ResponseEntity<List<Alunos>> findAll(){
		List<Alunos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
