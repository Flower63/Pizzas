package com.maven_project.pizzas.repository.pizza;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.domain.Pizza.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"})
public class JpaPizzaRepositoryTest {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Test
	public void testSavePizza() {
		Pizza pizza = new Pizza();
		pizza.setName("Test pizza 1");
		pizza.setCost(100);
		pizza.setType(Type.VEGETERIAN);
		
		pizzaRepository.savePizza(pizza);

		assertNotNull(pizza.getId());
	}

	@Test
	public void testGetPizzaByID() {
		Pizza pizza = new Pizza();
		pizza.setName("Test pizza 2");
		pizza.setCost(100);
		pizza.setType(Type.VEGETERIAN);

		pizzaRepository.savePizza(pizza);

		assertNotNull(pizzaRepository.getPizzaByID(pizza.getId()));
	}

	@Test
	public void testDeletePizza() {
		Pizza pizza = new Pizza();
		pizza.setName("Test pizza 3");
		pizza.setCost(100);
		pizza.setType(Type.VEGETERIAN);

		pizzaRepository.savePizza(pizza);

		assertNotNull(pizzaRepository.getPizzaByID(pizza.getId()));

		assertTrue(pizzaRepository.deletePizza(pizza));

		assertNull(pizzaRepository.getPizzaByID(pizza.getId()));
	}

	@Test
	public void testUpdatePizza() {
		Pizza pizza = new Pizza();
		pizza.setName("Test pizza 4");
		pizza.setCost(100);
		pizza.setType(Type.VEGETERIAN);

		pizzaRepository.savePizza(pizza);

		pizza.setType(Type.SEA);
		pizza.setName("Updated pizza");

		pizzaRepository.updatePizza(pizza);

		Pizza newPizza = pizzaRepository.getPizzaByID(pizza.getId());

		assertTrue(newPizza.getType() == Type.SEA);

		assertTrue(newPizza.getName().equals("Updated pizza"));
	}

}
