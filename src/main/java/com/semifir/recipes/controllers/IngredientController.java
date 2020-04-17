package com.semifir.recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.recipes.models.Ingredient;
import com.semifir.recipes.services.IngredientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("ingredients")
@CrossOrigin
public class IngredientController {

	@Autowired
	private IngredientService  service;
	
	@GetMapping("")
	public Flux<Ingredient> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping("")
	public Mono<Ingredient> save(@RequestBody Ingredient entity) {
		return this.service.save(entity);
	}
	
	
}
