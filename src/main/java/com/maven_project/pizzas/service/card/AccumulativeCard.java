package com.maven_project.pizzas.service.card;

import com.maven_project.pizzas.domain.Customer;

public class AccumulativeCard {
	private double totalAmount;
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

	public void addToTotalAmount(double totalAmount) {
		this.totalAmount += totalAmount;
	}
}
