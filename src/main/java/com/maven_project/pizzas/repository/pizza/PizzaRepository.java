package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.Pizza;

public interface PizzaRepository {
	void cookPizzas();

	Pizza getPizzaByID(Integer id);
}
