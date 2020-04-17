package com.semifir.recipes.services.generics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractReactiveServiceImpl<T> implements ReactiveService<T>{

	@Autowired
	private ReactiveMongoRepository<T, String> repository;
	
	public Flux<T> findAll(){
		return this.repository.findAll();
	}
	
	public Mono<T> save(T entity) {
		return this.repository.save(entity);
	}
	
	public Mono<T> findById(String id){
		return this.repository.findById(id);
	}
	
	public Mono<T> update(T entity) {
		return this.repository.save(entity);
	}
	
	public void deleteById(String id) {
		this.repository.deleteById(id);
	}
	
	public void delete(T entity) {
		this.repository.delete(entity);
	}
	
	public Mono<Long> count() {
		return this.repository.count();
	}
}

