package com.maven_project.pizzas;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.maven_project.pizzas.domain.Customer;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class RegistratedCustomer extends Customer {
	@Temporal(value=TemporalType.DATE)
	private Date date;

	public RegistratedCustomer() {
		this.date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
