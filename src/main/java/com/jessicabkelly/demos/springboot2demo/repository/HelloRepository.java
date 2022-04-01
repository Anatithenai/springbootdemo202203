package com.jessicabkelly.demos.springboot2demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.jessicabkelly.demos.springboot2demo.dto.Hello;

public interface HelloRepository extends CrudRepository<Hello, Long>{
	
	public Hello findByName(String name);

}
