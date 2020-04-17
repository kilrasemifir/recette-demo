package com.semifir.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemeRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemeRecipeApplication.class, args);
	}

}
