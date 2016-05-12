package com.maven_project.pizzas.repository.pizza;

import static org.junit.Assert.*;

import org.junit.Before;
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

	private Pizza pizza;

	@Before
	public void addPizza() {
		pizza = new Pizza();
		pizza.setName("Test pizza");
		pizza.setCost(100);
		pizza.setType(Type.VEGETERIAN);
	}
	
	@Test
	public void testSavePizza() {
		pizzaRepository.savePizza(pizza);

		assertNotNull(pizza.getId());
	}

	@Test
	public void testGetPizzaByID() {
		pizzaRepository.savePizza(pizza);

		assertNotNull(pizzaRepository.getPizzaByID(pizza.getId()));
	}

	@Test
	public void testDeletePizza() {
		pizzaRepository.savePizza(pizza);

		assertNotNull(pizzaRepository.getPizzaByID(pizza.getId()));

		assertTrue(pizzaRepository.deletePizza(pizza));

		assertNull(pizzaRepository.getPizzaByID(pizza.getId()));
	}

	@Test
	public void testUpdatePizza() {
		pizzaRepository.savePizza(pizza);

		pizza.setType(Type.SEA);
		pizza.setName("Updated pizza");

		pizzaRepository.updatePizza(pizza);

		Pizza newPizza = pizzaRepository.getPizzaByID(pizza.getId());

		assertTrue(newPizza.getType() == Type.SEA);

		assertTrue(newPizza.getName().equals("Updated pizza"));
	}

}
