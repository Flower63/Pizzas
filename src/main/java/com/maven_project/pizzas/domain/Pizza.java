package com.maven_project.pizzas.domain;

public class Pizza {
	private Integer id;
	private String name;
	private Type type;
	private double cost;
	
	public Pizza(Integer id, String name, Type type, Double cost) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
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

	public static enum Type {
		SEA, VEGETERIAN, REGULAR
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
}
