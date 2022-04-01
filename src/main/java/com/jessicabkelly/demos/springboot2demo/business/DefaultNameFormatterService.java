package com.jessicabkelly.demos.springboot2demo.business;

import org.springframework.stereotype.Service;

@Service("defaultNameFormatterService")
public class DefaultNameFormatterService implements NameFormatterService {

	@Override
	public String formatName(String name) {
		if (name != null) {
			return name + "!";
		} else {
			return null;
		}
		
	}

}
