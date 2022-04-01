package com.jessicabkelly.demos.springboot2demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jessicabkelly.demos.springboot2demo.dto.Hello;

@SpringBootTest
class HelloRepositoryTest {
	
	@Autowired
	HelloRepository helloRepository;

	@Test
	void test() {
		helloRepository.save(new Hello("Cara"));
		helloRepository.save(new Hello("Red"));
		assertEquals(2, helloRepository.count());
		assertEquals("Cara", helloRepository.findByName("Cara").getName());
		assertEquals(2, helloRepository.findByName("Red").getId());
		assertEquals(true, helloRepository.findById(123L).isEmpty());
	}

}
