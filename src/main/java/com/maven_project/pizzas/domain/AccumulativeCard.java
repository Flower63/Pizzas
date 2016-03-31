package com.maven_project.pizzas.domain;

public class AccumulativeCard {
	private double totalAmount;

	public double getTotalAmount() {
		return totalAmount;
	}

	public void addToTotalAmount(double totalAmount) {
		this.totalAmount += totalAmount;
	}
}
