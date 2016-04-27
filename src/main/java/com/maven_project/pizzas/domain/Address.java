package com.maven_project.pizzas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String city;
	private String street;
	private String appartment;
	
	public Address(String city, String street, String appartment) {
		this.city = city;
		this.street = street;
		this.appartment = appartment;
	}

	public Address() {}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getAppartment() {
		return appartment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}
}
