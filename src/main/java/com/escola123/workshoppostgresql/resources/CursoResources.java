
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

import com.escola123.workshoppostgresql.domain.Curso;
import com.escola123.workshoppostgresql.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResources {

	@Autowired
	private CursoService service;

	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		List<Curso> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id) {
		Curso obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Curso> insert(@RequestBody Curso cursoObj) {

		cursoObj = service.insert(cursoObj);
		return ResponseEntity.ok().body(cursoObj);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
