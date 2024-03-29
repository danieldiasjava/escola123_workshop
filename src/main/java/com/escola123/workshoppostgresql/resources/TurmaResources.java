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

import com.escola123.workshoppostgresql.domain.Turma;
import com.escola123.workshoppostgresql.services.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaResources {

	@Autowired
	private TurmaService service;

	@GetMapping
	public ResponseEntity<List<Turma>> findAll() {
		List<Turma> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Long id) {
		Turma obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Turma> insert(@RequestBody Turma TurmaObj) {
		TurmaObj = service.insert(TurmaObj);
		return ResponseEntity.ok().body(TurmaObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Turma> update(@PathVariable Long id, @RequestBody Turma obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
