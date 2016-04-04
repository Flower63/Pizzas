package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.Pizza;
import com.maven_project.pizzas.ifrastructure.Benchmark;

public interface PizzaRepository {
	void cookPizzas();

	@Benchmark
	Pizza getPizzaByID(Integer id);

	void init();
}
