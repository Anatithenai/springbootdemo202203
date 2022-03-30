package com.jessicabkelly.demos.springboot2demo.business;

import org.springframework.stereotype.Service;

@Service("smileyNameFormatterService")
public class SmileyNameFormatterService implements NameFormatterService {

	@Override
	public String formatName(String name) {
		return name + " :)";
	}

}
