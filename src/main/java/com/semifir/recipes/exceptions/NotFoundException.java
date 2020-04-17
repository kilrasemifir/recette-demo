package com.semifir.recipes.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException{

	private static Logger logger = LoggerFactory.getLogger(NotFoundException.class);
	
	private static final long serialVersionUID = 1L;

	public NotFoundException(String id, String model) {
		super(HttpStatus.NOT_FOUND, "L'id ("+id+") de "+model+" n'est pas valide");
		logger.warn("ID NOT FOUND"+id);
	}

}
