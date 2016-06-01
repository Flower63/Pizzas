package com.maven_project.pizzas.rest;

import org.springframework.hateoas.ResourceSupport;

import com.maven_project.pizzas.domain.Pizza;

public class PizzaResource extends ResourceSupport {
	
	private Integer pizzaId;
	private String name;
	private Pizza.Type type;
	private double cost;
	
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer id) {
		this.pizzaId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pizza.Type getType() {
		return type;
	}
	public void setType(Pizza.Type type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
