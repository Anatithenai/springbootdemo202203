package com.jessicabkelly.demos.springboot2demo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DefaultNameFormatterServiceTest {
	
	@Autowired
	private DefaultNameFormatterService defaultNameFormatterService;

	@Test
	void testFormatterWithNonNullInput() {
		String output = defaultNameFormatterService.formatName("Jessica");
		assertEquals("Jessica!", output);
	}
	
	@Test
	void testFormatterWithNullInput() {
		try {
			String output = defaultNameFormatterService.formatName(null);
			assertNull(output);
		} catch (Exception ex) {
			fail("Exception was thrown");
		}
	}

}
