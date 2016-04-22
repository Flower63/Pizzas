package com.maven_project.pizzas;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Address {
	
	@Id
	@Column(name="ADDR_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String actualy;
	
	@Column(name="ADDR_STATE")
	@Convert(converter = StateConverter.class)
	//@Type(type="org.hibernate.type.TextType")
	private State state;
	//@OneToOne(mappedBy="address")
	@ManyToOne//(optional=false)
	@JoinTable(name="cust_addr")
	private Customer customer;

	public String getActualy() {
		return actualy;
	}

	public void setActualy(String actualy) {
		this.actualy = actualy;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
