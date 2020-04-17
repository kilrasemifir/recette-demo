package com.semifir.recipes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecetteFormatDTO {

	private String content;
	
	public long getSize() {
		return this.content.length();
	}
}
