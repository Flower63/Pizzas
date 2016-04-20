package com.maven_project.pizzas;

import javax.persistence.*;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	@Column(name="pizza_type")
	@Enumerated(EnumType.ORDINAL)
	private Type type;
	private double cost;
	
	public Pizza(Integer id, String name, Type type, double cost) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.cost = cost;
	}

	public Pizza() {
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

	public void setId(Integer id) {
		this.id = id;
	}

	public static enum Type {
		SEA, VEGETERIAN, REGULAR
	}
	
}
