package com.semifir.recipes.services.impl;

import org.springframework.stereotype.Service;

import com.semifir.recipes.models.Ingredient;
import com.semifir.recipes.services.IngredientService;
import com.semifir.recipes.services.generics.AbstractReactiveServiceImpl;

@Service
public class IngredientServiceImpl extends AbstractReactiveServiceImpl<Ingredient> implements IngredientService{
}
