package com.maven_project.pizzas.repository.pizza;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.domain.Pizza.Type;
import com.maven_project.pizzas.ifrastructure.Benchmark;
import com.maven_project.pizzas.ifrastructure.PostConstruct;

@Deprecated
public class InMemPizzaRepository implements PizzaRepository {
	private List<Pizza> pizzasList = new ArrayList<Pizza>();

	@PostConstruct
	public void cookPizzas() {
//		pizzasList.add(new Pizza(1, "Sea pizza 1", Type.SEA));
//		pizzasList.add(new Pizza(2, "Regular pizza 1", Type.REGULAR));
//		pizzasList.add(new Pizza(3, "Vegeterian pizza 1", Type.VEGETERIAN));
	}

	@Benchmark
	public Pizza getPizzaByID(Integer id) {
		for(Pizza p : pizzasList) {
			if (p.getPizzaId().equals(id)) {
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

	public int savePizza(Pizza pizza) {
		return 0;
	}

	public boolean deletePizza(Pizza pizza) {
		return false;
	}

	public boolean updatePizza(Pizza pizza) {
		return false;
	}

	public List<Pizza> getAllPizzas() {
		return pizzasList;
	}

	@Override
	public <S extends Pizza> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pizza> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Pizza> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Pizza> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pizza entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Pizza> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
