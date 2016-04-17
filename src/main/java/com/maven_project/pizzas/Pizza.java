package com.maven_project.pizzas;

public class Pizza {
	private Integer id;
	private String name;
	private Type type;
	private double cost;
	
	public Pizza(Integer id, String name, Type type, double cost) {
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

	public static enum Type {
		SEA, VEGETERIAN, REGULAR
	}
}
