package com.maven_project.pizzas;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.domain.Pizza.Type;

public class CreatePizzaService {
	public Pizza createPizza(int id, String name, Type type, Double cost) {
		return new Pizza(id, name, type, cost);
	}
}
