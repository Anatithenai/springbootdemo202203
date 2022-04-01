package com.jessicabkelly.demos.springboot2demo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmileyNameFormatterServiceTest {
	
	@Autowired
	SmileyNameFormatterService smileyNameFormatterService;

	@Test
	void testFormatterWithNonNullInput() {
		String output = smileyNameFormatterService.formatName("Jessica");
		assertEquals("Jessica :)", output);
	}
	
	@Test
	void testFormatterWithNullInput() {
		try {
			String output = smileyNameFormatterService.formatName(null);
			assertNull(output);
		} catch (Exception ex) {
			fail("Exception was thrown");
		}
	}

}
