package com.semifir.recipes.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.semifir.recipes.models.Ingredient;

public interface IngredientRepository extends ReactiveMongoRepository<Ingredient, String>{

}
