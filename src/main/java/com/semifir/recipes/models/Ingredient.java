package com.semifir.recipes.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Ingredient {

	@Id
	private String id;
	private String nom;
	private String unit;
}
