package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.domain.Pizza;

public interface PizzaRepository {
	Pizza getPizzaByID(Integer id);
}
