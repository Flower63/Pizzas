package com.maven_project.pizzas.domain;

import javax.persistence.*;

@Entity
public class AccumulativeCard {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void addToTotalAmount(double totalAmount) {
		this.totalAmount += totalAmount;
	}

	@Override
	public String toString() {
		return "AccumulativeCard [id=" + id + ", totalAmount=" + totalAmount + ", customer=" + customer.getName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccumulativeCard other = (AccumulativeCard) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}
}
