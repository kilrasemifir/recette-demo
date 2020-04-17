package com.semifir.recipes.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Etape {

	private String nom;
	private String description;
}
