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

	public enum Type {
		SEA, VEGETERIAN, REGULAR
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pizza)) return false;

		Pizza pizza = (Pizza) o;

		if (Double.compare(pizza.getCost(), getCost()) != 0) return false;
		if (!getId().equals(pizza.getId())) return false;
		if (!getName().equals(pizza.getName())) return false;
		return getType() == pizza.getType();
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type=" + type +
				", cost=" + cost +
				'}';
	}
}
