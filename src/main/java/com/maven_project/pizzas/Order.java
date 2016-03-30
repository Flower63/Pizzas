package com.maven_project.pizzas;

import java.util.List;

public class Order {
	private Long id;
	private Customer customer;
	private List<Pizza> pizzas;

	public Order(Customer customer, List<Pizza> pizzas) {
		this.customer = customer;
		this.pizzas = pizzas;
	}

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
		// TODO Auto-generated method stub
		return "Order with pizzas";
	}
}
