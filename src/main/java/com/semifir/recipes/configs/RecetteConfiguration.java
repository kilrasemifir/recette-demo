package com.semifir.recipes.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.semifir.recipes.services.IngredientService;
import com.semifir.recipes.services.RecetteService;
import com.semifir.recipes.services.impl.RecetteServiceImpl;

@Configuration
public class RecetteConfiguration {

	@Value("${localisation:eu}")
	private String localisation;
	
	@Bean
	public RecetteService recetteService(IngredientService ingredientService) {
		if (localisation.equals("eu"))
			return new RecetteServiceImpl(ingredientService);
		else if(localisation.equals("us"))
			return new RecetteServiceImpl(ingredientService);
		return new RecetteServiceImpl(ingredientService);
	}
}
