package com.maven_project.pizzas;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.domain.Pizza.Type;

public class CreatePizzaService {
	public Pizza createPizza(String name, Type type, Double cost) {
		return new Pizza(name, type, cost);
	}
}
