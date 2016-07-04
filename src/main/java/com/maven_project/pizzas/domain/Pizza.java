package com.maven_project.pizzas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer pizzaId;

	private String name;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "PIZZA_TYPE")
	private Type type;

	private Double price;

	public Pizza(String name, Type type, Double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public Pizza() {}

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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public enum Type {
		SEA,
		VEGETERIAN,
		REGULAR
	}

	@Override
	public String toString() {
		return "Pizza [id=" + pizzaId + ", name=" + name + ", type=" + type + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Pizza))
			return false;

		Pizza pizza = (Pizza) o;

		if (getPizzaId() != pizza.getPizzaId())
			return false;
		return getName().equals(pizza.getName());

	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}
}
