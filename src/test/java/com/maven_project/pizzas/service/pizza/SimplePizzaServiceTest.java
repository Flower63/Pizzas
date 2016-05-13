package com.maven_project.pizzas.service.pizza;

import org.junit.Before;
import org.junit.Test;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

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
		
		verify(pizzaRepository).getPizzaByID(5);
	}

	@Test
	public void testSavePizza() {
		Pizza pizza = new Pizza();
		
		pizzaService.savePizza(pizza);
		
		verify(pizzaRepository).savePizza(pizza);
	}

	@Test
	public void testDeletePizza() {
		Pizza pizza = new Pizza();
		
		pizzaService.deletePizza(pizza);
		
		verify(pizzaRepository).deletePizza(pizza);
	}

	@Test
	public void testUpdatePizza() {
		Pizza pizza = new Pizza();
		
		pizzaService.updatePizza(pizza);
		
		verify(pizzaRepository).updatePizza(pizza);
	}

}
