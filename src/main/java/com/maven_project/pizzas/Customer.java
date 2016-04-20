package com.maven_project.pizzas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.FactoryBean;

@Entity
public class Customer implements FactoryBean<Customer> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	@Embedded
	@Column(name="ADDR")
	private Address address;
	@ElementCollection
	private List<String> phones;
	@ElementCollection
	List<Address> addresses;
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
