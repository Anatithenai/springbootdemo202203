package com.jessicabkelly.demos.springboot2demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jessicabkelly.demos.springboot2demo.business.NameFormatterService;
import com.jessicabkelly.demos.springboot2demo.dto.Hello;
import com.jessicabkelly.demos.springboot2demo.repository.HelloRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoRestController {

	private NameFormatterService nameFormatterService;
	private HelloRepository helloRepository;
	
	@Autowired
	public DemoRestController(@Qualifier("smileyNameFormatterService") NameFormatterService nameFormatterService,
				HelloRepository helloRepository) {
		this.nameFormatterService = nameFormatterService;
		this.helloRepository = helloRepository;
	}
	
	@GetMapping(path = "/hello")
	public String getHello(@RequestParam(name = "name", defaultValue = "World") String name) {
		try {
			return "Hello " +
					nameFormatterService.formatName(name) +
					" ID: " + helloRepository.findByName(name).getId();
		} catch (Exception ex) {
			log.error("Error getting by name", ex);
			return "No data found :( ";
		}
	}
	
	@GetMapping(path = "/hello/{id}")
	public String getHelloById(@PathVariable long id) {
		try{
			Hello hello = helloRepository.findById(id).get();
			return "Hello " +
					nameFormatterService.formatName(hello.getName()) +
					" ID: " + hello.getId();
		} catch (Exception ex) {
			log.error("Error getting by id", ex);
			return "No data found :( ";
		}
	}
	
	@PostMapping(path = "/hello")
	public String postHello(@RequestBody Hello hello) {
		hello = helloRepository.save(hello);
		return "Hello with id = " + hello.getId() + " created for: " + hello.getName();
	}
}
