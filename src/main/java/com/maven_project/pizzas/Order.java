package com.maven_project.pizzas;

import java.util.List;
import java.util.Map;

public class Order {
	private Long id;
	private Customer customer;
	private List<Pizza> pizzas;
	private Map<Pizza, Integer> orders;
	/* TODO add date */
	/* TODO add address */

	public Order(Customer customer, List<Pizza> pizzas) {
		this.customer = customer;
		this.pizzas = pizzas;
		fillMap(pizzas);
	}
	
	public Order() {}

	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	@Override
	public String toString() {
		return "Order with pizzas";
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	private void fillMap(List<Pizza> pizzas) {
		for (Pizza p : pizzas) {
			if (orders.containsKey(p)) {
				int quantity = orders.get(p);
				orders.put(p, ++quantity);
			} else {
				orders.put(p, 0);
			}
		}
	}
}
