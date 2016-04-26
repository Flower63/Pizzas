package com.maven_project.pizzas;

import javax.persistence.*;

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
	//@ManyToOne//(optional=false)
	//@JoinTable(name="cust_addr")
	@Transient
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
