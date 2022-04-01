package com.jessicabkelly.demos.springboot2demo.web;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.jessicabkelly.demos.springboot2demo.dto.Cat;
import com.jessicabkelly.demos.springboot2demo.repository.CatRepository;

@SpringBootTest
@AutoConfigureMockMvc
class CatRestControllerTest {
	
	@Autowired
	CatRepository catRepository;
	
	@Autowired
	CatRestController catRestController;
	
	@Autowired
	MockMvc mockMvc;
	
	private Long anIdOfSomeCat = -1L;
	
	@BeforeEach
	void setUpH2Entries() {
		catRepository.deleteAll();
		catRepository.save(new Cat("Cara"));
		catRepository.save(new Cat("Red"));
		anIdOfSomeCat = catRepository.save(new Cat("Cassie")).getId();
	}

	@Test
	void testContextLoads() {
		assertNotNull(catRestController);
	}
	
	@Test
	void testGetByNameWhenDataFound() throws Exception {
		mockMvc.perform(get("/cat?name=Red")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testGetByNameWhenDataNotFound() throws Exception {
		mockMvc.perform(get("/cat?name=Fred")).andDo(print()).andExpect(status().isNotFound());
	}
	
	@Test
	void testGetByIdWhenDataFound() throws Exception {
		mockMvc.perform(get("/cat/" + anIdOfSomeCat)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testGetByIdWhenDataNotFound() throws Exception {
		mockMvc.perform(get("/cat/123456")).andDo(print()).andExpect(status().isNotFound());
	}

}
