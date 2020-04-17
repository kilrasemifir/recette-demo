package com.semifir.recipes.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document("recettes")
@Data
@NoArgsConstructor
public class Recette {

	@Id
	private String id;
	
	private String titre;
	private String description;
	
	private long duree;
	private LocalDate creationDate;
	private Set<Etape> etapes = new HashSet<>();
	
	@DBRef
	private List<Ingredient> ingredients = new ArrayList<>();
	
	@Transient
	private LocalDateTime updateTime;
	
}
