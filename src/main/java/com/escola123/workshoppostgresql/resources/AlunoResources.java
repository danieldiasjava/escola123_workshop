package com.escola123.workshoppostgresql.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola123.workshoppostgresql.domain.Aluno;
import com.escola123.workshoppostgresql.services.AlunoService;


@RestController
@RequestMapping(value="/alunos")
public class AlunoResources {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id){
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> insert(@RequestBody Aluno alunosObj){
		alunosObj = service.insert(alunosObj);
		return ResponseEntity.ok().body(alunosObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
