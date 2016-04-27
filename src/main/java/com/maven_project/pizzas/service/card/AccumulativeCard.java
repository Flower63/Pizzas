package com.maven_project.pizzas.service.card;

import com.maven_project.pizzas.domain.Customer;

import javax.persistence.*;

@Entity
public class AccumulativeCard {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private double totalAmount;

	@ManyToOne
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addToTotalAmount(double totalAmount) {
		this.totalAmount += totalAmount;
	}
}
