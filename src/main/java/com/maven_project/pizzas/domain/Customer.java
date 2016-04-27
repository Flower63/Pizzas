package com.maven_project.pizzas.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<Address> addresses;

	public Customer() {
	}

	public Customer(int id, String name, List<Address> addresses) {
		this.id = id;
		this.name = name;
		this.addresses = addresses;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
