package com.semifir.recipes.services.generics;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveService<T> {

	public Flux<T> findAll();
	
	public Mono<T> save(T entity);
	
	public Mono<T> findById(String id);
	
	public Mono<T> update(T entity);
	
	public void deleteById(String id);
	
	public void delete(T entity);
	
	public Mono<Long> count();
}
