package com.jessicabkelly.demos.springboot2demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jessicabkelly.demos.springboot2demo.dto.Cat;

@SpringBootTest
class CatRepositoryTest {
	
	@Autowired
	CatRepository helloRepository;
	
	@BeforeEach
	void setup() {
		helloRepository.deleteAll();
		helloRepository.save(new Cat("Cara"));
		helloRepository.save(new Cat("Red"));
	}

	@Test
	void testFindByNameWhenDataShouldBePresent() {
		assertEquals("Cara", helloRepository.findByName("Cara").getName());
		assertNotNull(helloRepository.findByName("Red").getId());
	}
	
	@Test
	void testFindByNameWhenDataShouldNotBePresent() {
		assertTrue(helloRepository.findById(1234567890L).isEmpty());
	}

}
