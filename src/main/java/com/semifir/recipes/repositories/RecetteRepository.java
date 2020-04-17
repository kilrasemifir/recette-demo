package com.semifir.recipes.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.semifir.recipes.models.Recette;

public interface RecetteRepository extends ReactiveMongoRepository<Recette, String>{
	
}
