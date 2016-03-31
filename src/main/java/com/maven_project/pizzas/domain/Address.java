package com.maven_project.pizzas.domain;

public class Address {
	private String city;
	private String street;
	private String appartment;
	
	public Address(String city, String street, String appartment) {
		this.city = city;
		this.street = street;
		this.appartment = appartment;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getAppartment() {
		return appartment;
	}
}
