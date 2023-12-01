package com.escola123.workshoppostgresql.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola123.workshoppostgresql.domain.Professor;
import com.escola123.workshoppostgresql.services.ProfessorService;


@RestController
@RequestMapping(value="/professores")
public class ProfessorResources {
	
	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public ResponseEntity<List<Professor>> findAll(){
		List<Professor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Professor> insert(@RequestBody Professor profObj){
		profObj = service.insert(profObj);
		return ResponseEntity.ok().body(profObj);
	}
}
