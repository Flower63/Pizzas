package com.maven_project.pizzas.web.utils.resource;

import com.maven_project.pizzas.domain.Pizza;

import org.springframework.hateoas.ResourceSupport;

public class PizzaResource extends ResourceSupport {
	private Integer pizzaId;
	private String name;
	private Pizza.Type type;
	private Double price;

	public Integer getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
