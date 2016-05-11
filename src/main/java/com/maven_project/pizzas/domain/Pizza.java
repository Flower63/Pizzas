package com.maven_project.pizzas.domain;

import javax.persistence.*;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String name;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "PIZZA_TYPE")
	private Type type;

	private double cost;
	
	public Pizza(String name, Type type, Double cost) {
		this.name = name;
		this.type = type;
		this.cost = cost;
	}

	public Pizza() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public enum Type {
		SEA, VEGETERIAN, REGULAR
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pizza)) return false;

		Pizza pizza = (Pizza) o;

		if (getId() != pizza.getId()) return false;
		return getName().equals(pizza.getName());

	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}
}
