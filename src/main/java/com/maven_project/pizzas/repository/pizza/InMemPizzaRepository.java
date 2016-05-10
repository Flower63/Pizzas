package com.maven_project.pizzas.repository.pizza;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.domain.Pizza.Type;

@Repository(value="inMemPizzaRepository")
public class InMemPizzaRepository implements PizzaRepository {
	private List<Pizza> pizzasList = new ArrayList<>();
	
	@PostConstruct
	public void cookPizzas() {
		pizzasList.add(new Pizza(1, "Sea pizza 1", Type.SEA, 12.5));
		pizzasList.add(new Pizza(2, "Regular pizza 1", Type.REGULAR, 14.0));
		pizzasList.add(new Pizza(3, "Vegeterian pizza 1", Type.VEGETERIAN, 11.7));
	}

	@Override
	public Pizza getPizzaByID(Integer id) {
		for(Pizza p : pizzasList) {
			if (p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}

	@Override
	public Integer savePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
