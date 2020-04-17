package com.semifir.recipes.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.semifir.recipes.dto.RecetteFormatDTO;
import com.semifir.recipes.models.Etape;
import com.semifir.recipes.models.Ingredient;
import com.semifir.recipes.models.Recette;
import com.semifir.recipes.services.IngredientService;
import com.semifir.recipes.services.RecetteService;
import com.semifir.recipes.services.generics.AbstractReactiveServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RecetteServiceImpl extends AbstractReactiveServiceImpl<Recette> implements RecetteService{
	
	private IngredientService ingredientService;

	public RecetteServiceImpl(IngredientService ingredientService) {
		super();
		this.ingredientService = ingredientService;
	}

	@Override
	public Mono<Recette> save(Recette entity) {
		entity.setCreationDate(LocalDate.now());
		return super.save(entity);
	}
	
	@Override
	public Flux<Recette> findAll(){
		return super.findAll().map(recette -> {
			recette.setUpdateTime(LocalDateTime.now());
			if (recette.getId().equals("5e99ae692f1485764be4635b")) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return recette;
		});
	}
	
	public Mono<Recette> addIngredient(String rid, String iid) {
		Mono<Recette> monoRecette = this.findById(rid);
		Mono<Ingredient> monoIngredient = this.ingredientService.findById(iid);
		
		return Mono.zip(monoRecette, monoIngredient,(recette, ingredient)->{
			recette.getIngredients().add(ingredient);
			this.save(recette);
			return recette;
		});
	}
	
	public Mono<RecetteFormatDTO> format(String id) {
		return this.findById(id).map(recette -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Titre:").append(recette.getTitre()).append("\n\n");
			sb.append("Description:").append(recette.getDescription()).append("\n\n");
			sb.append("Ingredients:\n");
			
			List<Ingredient> ingredients = recette.getIngredients().stream()
				.sorted((i1, i2)-> i1.getNom().compareTo(i2.getNom()))
				.collect(Collectors.toList());
			
			for (Ingredient ingredient: ingredients) {
				sb.append("    ").append(ingredient.getNom()).append('\n');
			}
			sb.append("\nEtapes:\n");
			for (Etape etape : recette.getEtapes()) {
				sb.append("    ").append(etape.getNom()).append(":").append(etape.getDescription()).append('\n');
			}
			
			return new RecetteFormatDTO(sb.toString());
		});
		
	}
}
