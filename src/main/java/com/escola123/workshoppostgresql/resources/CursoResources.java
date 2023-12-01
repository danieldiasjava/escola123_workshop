
package com.escola123.workshoppostgresql.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola123.workshoppostgresql.domain.Curso;
import com.escola123.workshoppostgresql.services.CursoService;

@RestController
@RequestMapping(value="/cursos")
public class CursoResources {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll(){
		List<Curso> list = cursoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Curso> insert(@RequestBody Curso cursoObj){
		
		cursoObj = cursoService.insert(cursoObj);
		return ResponseEntity.ok().body(cursoObj);
		
	}
}
