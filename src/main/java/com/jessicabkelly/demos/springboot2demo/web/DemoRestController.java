package com.jessicabkelly.demos.springboot2demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	@GetMapping(path = "/hello")
	public String getHello() {
		return "Hello World!";
	}
}
