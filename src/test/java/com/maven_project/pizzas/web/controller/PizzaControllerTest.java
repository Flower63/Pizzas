package com.maven_project.pizzas.web.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"
									, "classpath:appContext.xml"
									, "classpath:webContext.xml"})
public class PizzaControllerTest {
	
	@Autowired 
	private WebApplicationContext wac;
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
    @Autowired 
    private MockHttpSession session;
    
    @Autowired 
    private MockHttpServletRequest request;
	
	private MockMvc mockMvc;
	private Pizza pizza1;
	private Pizza pizza2;
	
	@Before
	public void setUp() {
		pizza1 = new Pizza();
		pizza1.setName("TestPizza1");
		pizza1.setCost(121);
		pizza1.setType(Pizza.Type.SEA);
		
		pizza2 = new Pizza();
		pizza2.setName("TestPizza2");
		pizza2.setCost(150);
		pizza2.setType(Pizza.Type.REGULAR);
		
		pizzaRepository.save(pizza1);
		pizzaRepository.save(pizza2);
		
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@After
	public void clean() {
		pizzaRepository.delete(pizza1);
		pizzaRepository.delete(pizza2);
	}

	@Test
	public void testGetPizzaById() {
		
	}

	@Test
	public void testGetIndex() {
		
	}

	@Test
	public void testAdd() {
		
	}

	@Test
	public void testEdit() {
		
	}

	@Test
	public void testShowPizzas() {
		
	}

	@Test
	public void testAllPizzas() throws Exception {
		mockMvc.perform(get("/all"))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$[*]", hasSize(2)))
		.andExpect(jsonPath("$[0].name", is(pizza1.getName())))
		.andExpect(jsonPath("$[0].cost", is(pizza1.getCost())))
		.andExpect(jsonPath("$[0].type", is(pizza1.getType().toString())))
		.andExpect(jsonPath("$[1].name", is(pizza2.getName())))
		.andExpect(jsonPath("$[1].cost", is(pizza2.getCost())))
		.andExpect(jsonPath("$[1].type", is(pizza2.getType().toString())));
	}

}
