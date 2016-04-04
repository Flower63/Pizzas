package com.maven_project.pizzas.repository.pizza;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.Pizza;
import com.maven_project.pizzas.Pizza.Type;
import com.maven_project.pizzas.ifrastructure.Benchmark;
import com.maven_project.pizzas.ifrastructure.PostConstruct;

public class InMemPizzaRepository implements PizzaRepository {
	private List<Pizza> pizzasList = new ArrayList<Pizza>();

	@PostConstruct
	public void cookPizzas() {
		pizzasList.add(new Pizza(1, "Sea pizza 1", Type.SEA));
		pizzasList.add(new Pizza(2, "Regular pizza 1", Type.REGULAR));
		pizzasList.add(new Pizza(3, "Vegeterian pizza 1", Type.VEGETERIAN));
	}

	@Benchmark
	@Override
	public Pizza getPizzaByID(Integer id) {
		for(Pizza p : pizzasList) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		
		return null;
	}
	
	public void init() {
		System.out.println("init method in " + this.getClass().getSimpleName());
	}

}
