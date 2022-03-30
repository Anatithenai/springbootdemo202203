package com.jessicabkelly.demos.springboot2demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jessicabkelly.demos.springboot2demo.business.NameFormatterService;

@RestController
public class DemoRestController {
	
	private NameFormatterService nameFormatterService;
	
	
	@Autowired
	public DemoRestController(NameFormatterService nameFormatterService) {
		super();
		this.nameFormatterService = nameFormatterService;
	}
	
	@GetMapping(path = "/hello")
	public String getHello(@RequestParam(name = "name", defaultValue = "World") String name) {
		return "Hello " + nameFormatterService.formatName(name);
	}
}
