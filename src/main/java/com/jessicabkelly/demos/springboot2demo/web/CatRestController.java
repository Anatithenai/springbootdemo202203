package com.jessicabkelly.demos.springboot2demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jessicabkelly.demos.springboot2demo.business.NameFormatterService;
import com.jessicabkelly.demos.springboot2demo.dto.Cat;
import com.jessicabkelly.demos.springboot2demo.repository.CatRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CatRestController {
	
	private CatRepository catRepository;
	
	@Autowired
	public CatRestController(CatRepository catRepository) {
		this.catRepository = catRepository;
	}
	
	@GetMapping(path = "/cat")
	public ResponseEntity<Cat> getCatByName(@RequestParam(name = "name", defaultValue = "Kitty") String name) {
		try {
			Cat cat = catRepository.findByName(name);
			log.info("Found cat: {}", cat);
			if (cat.getId() == null) {
				return new ResponseEntity<Cat>(new Cat(), HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Cat>(catRepository.findByName(name), HttpStatus.OK);
			}
		} catch (Exception ex) {
			log.error("Error getting by name", ex);
			return new ResponseEntity<Cat>(new Cat(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = "/cat/{id}")
	public ResponseEntity<Cat> getCatById(@PathVariable long id) {
		try {
			Cat cat = catRepository.findById(id).get();
			log.info("Found cat: {}", cat);
			return new ResponseEntity<Cat>(cat, HttpStatus.OK);
		} catch (Exception ex) {
			log.error("Error getting by name", ex);
			return new ResponseEntity<Cat>(new Cat(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = "/cat")
	public ResponseEntity<Cat> postCat(@RequestBody Cat cat) {
		try {
			cat = catRepository.save(cat);
			return new ResponseEntity<Cat>(cat, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error creating {}", cat);
			return new ResponseEntity<Cat>(new Cat(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
