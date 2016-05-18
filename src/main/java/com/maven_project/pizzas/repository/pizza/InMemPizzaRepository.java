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
//		pizzasList.add(new Pizza(1, "Sea pizza 1", Type.SEA));
//		pizzasList.add(new Pizza(2, "Regular pizza 1", Type.REGULAR));
//		pizzasList.add(new Pizza(3, "Vegeterian pizza 1", Type.VEGETERIAN));
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
	
	public void setPizzasList(List<Pizza> pizzasList) {
		this.pizzasList = pizzasList;
	}

	public void init() {
		System.out.println("init method in " + this.getClass().getSimpleName());
	}

	@Override
	public int savePizza(Pizza pizza) {
		return 0;
	}

	@Override
	public boolean deletePizza(Pizza pizza) {
		return false;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {
		return false;
	}

	@Override
	public List<Pizza> getAllPizzas() {
		return pizzasList;
	}
}
