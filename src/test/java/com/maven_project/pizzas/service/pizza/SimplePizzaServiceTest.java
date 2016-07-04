package com.maven_project.pizzas.service.pizza;

import org.junit.Before;
import org.junit.Test;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.PizzaRepository;
import com.maven_project.pizzas.service.PizzaService;
import com.maven_project.pizzas.service.impl.SimplePizzaService;

import static org.mockito.Mockito.*;

public class SimplePizzaServiceTest {
	
	private PizzaRepository pizzaRepository;
	private PizzaService pizzaService;
	
	@Before
	public void makePizzaService() {
		pizzaRepository = mock(PizzaRepository.class);
		
		pizzaService = new SimplePizzaService(pizzaRepository);
	}

	@Test
	public void testGetPizzaByID() {
		pizzaService.getPizzaByID(5);
		
		verify(pizzaRepository).findOne(5);
	}

	@Test
	public void testSavePizza() {
		Pizza pizza = new Pizza();
		
		pizzaService.savePizza(pizza);
		
		verify(pizzaRepository).save(pizza);
	}

	@Test
	public void testDeletePizza() {
		Pizza pizza = new Pizza();
		
		pizzaService.deletePizza(pizza.getPizzaId());
		
		verify(pizzaRepository).delete(pizza);
	}
}
