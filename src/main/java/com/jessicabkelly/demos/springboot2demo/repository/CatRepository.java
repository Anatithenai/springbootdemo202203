package com.jessicabkelly.demos.springboot2demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.jessicabkelly.demos.springboot2demo.dto.Cat;

public interface CatRepository extends CrudRepository<Cat, Long>{
	
	public Cat findByName(String name);

}
