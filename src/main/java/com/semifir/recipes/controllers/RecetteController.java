package com.semifir.recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.recipes.annotations.RequestToLog;
import com.semifir.recipes.dto.RecetteFormatDTO;
import com.semifir.recipes.models.Recette;
import com.semifir.recipes.services.RecetteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("recettes")
@CrossOrigin
public class RecetteController {

	@Autowired
	private RecetteService service;
	
	@GetMapping("")
	@RequestToLog
	public Flux<Recette> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping("")
	public Mono<Recette> save(@RequestBody Recette entity) {
		return this.service.save(entity);
	}
	
	@GetMapping("{id}")
	public Mono<Recette> findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@PutMapping("")
	public Mono<Recette> update(@RequestBody Recette entity) {
		return this.service.update(entity);
	}
	
	@PostMapping("{rid}/ingredients/{iid}")
	public Mono<Recette> addIngredient(@PathVariable String rid, @PathVariable String iid) {
		return this.service.addIngredient(rid, iid);
	}
	
	@GetMapping("{id}/format")
	public Mono<RecetteFormatDTO> format(@PathVariable String id) {
		return this.service.format(id);
	}
}
