package com.maven_project.pizzas;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@Embeddable
public class Address {
	
	@Column(name="ADDR_ID")
	private int id;
	private String actualy;

	public String getActualy() {
		return actualy;
	}

	public void setActualy(String actualy) {
		this.actualy = actualy;
	}
	
	
}
