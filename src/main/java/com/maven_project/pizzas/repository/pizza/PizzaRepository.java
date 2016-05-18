package com.maven_project.pizzas.repository.pizza;

import java.util.List;

import com.maven_project.pizzas.Pizza;

public interface PizzaRepository {
	
	List<Pizza> getAllPizzas();

	Pizza getPizzaByID(Integer id);

	int savePizza(Pizza pizza);

	boolean deletePizza(Pizza pizza);

	boolean updatePizza(Pizza pizza);
}
