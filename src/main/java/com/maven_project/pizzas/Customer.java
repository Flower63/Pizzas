package com.maven_project.pizzas;

import org.springframework.beans.factory.FactoryBean;

public class Customer implements FactoryBean<Customer> {
	private int id;
	private String name;
	
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}

	@Override
	public Customer getObject() throws Exception {
		return new Customer(3, "Name");
	}

	@Override
	public Class<?> getObjectType() {
		return Customer.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
