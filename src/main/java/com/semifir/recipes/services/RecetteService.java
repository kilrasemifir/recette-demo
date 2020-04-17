package com.semifir.recipes.services;

import com.semifir.recipes.dto.RecetteFormatDTO;
import com.semifir.recipes.models.Recette;
import com.semifir.recipes.services.generics.ReactiveService;

import reactor.core.publisher.Mono;

public interface RecetteService extends ReactiveService<Recette>{
	
	public Mono<Recette> addIngredient(String rid, String iid);
	public Mono<RecetteFormatDTO> format(String id);
	
}
