package com.semifir.recipes.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // la classe est un controller d'API REST
@RequestMapping("demos")
@CrossOrigin()
public class DemoController {

	private static int count = 0;
	@RequestMapping
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping("bye")
	public String bye() {
		return "bye!!";
	}
	
	@GetMapping
	public String toto() {
		return "GET" + count ++;
	}
	
	@PostMapping
	public String titi() {
		return "POST";
	}
	
	@PutMapping
	public String tutu() {
		return "PUT";
	}
	
	@DeleteMapping
	public String tete() {
		return "DELETE";
	}
	
	@GetMapping("nom/{nom}")
	public String pv(@PathVariable String nom) {
		return nom +"!!!";
	}
	
	@GetMapping("{id}")
	public String pv(@PathVariable int id) {
		return ""+id + 10;
	}
	
	@PostMapping("data")
	public String gg(@RequestBody String str) {
		return str.toUpperCase();
	}
}
