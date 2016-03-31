package com.maven_project.pizzas.domain;

public class Customer {
	private int id;
	private String name;
	private Address address;
	private AccumulativeCard card;
	
	public Customer(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AccumulativeCard getCard() {
		return card;
	}

	public void setCard(AccumulativeCard card) {
		this.card = card;
	}
}
