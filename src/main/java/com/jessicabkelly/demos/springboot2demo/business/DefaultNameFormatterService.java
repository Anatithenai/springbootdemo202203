package com.jessicabkelly.demos.springboot2demo.business;

import org.springframework.stereotype.Service;

@Service
public class DefaultNameFormatterService implements NameFormatterService {

	@Override
	public String formatName(String name) {
		return name + "!";
	}

}
