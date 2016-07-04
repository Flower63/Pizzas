package com.maven_project.pizzas.service;

import com.maven_project.pizzas.domain.Customer;

public interface CustomerService {
	Customer findCustomer(Integer id);
	
	Customer findCustomer(String email);
	
	Integer saveCustomer(Customer customer);
	
	void deleteCustomer(Customer customer);
}
