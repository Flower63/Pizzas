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
		pizza.setName("Test pizza");
		pizza.setCost(100);
		pizza.setType(Type.VEGETERIAN);
		
		pizzaRepository.savePizza(pizza);
		
		System.out.println(pizza);
		
		assertNotNull(pizzaRepository.getPizzaByID(pizza.getId()));
	}

	@Test
	public void testGetPizzaByID() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeletePizza() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdatePizza() {
		//fail("Not yet implemented");
	}

}
