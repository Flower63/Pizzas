package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.Pizza;

public interface PizzaRepository {
	Pizza getPizzaByID(Integer id);
}
