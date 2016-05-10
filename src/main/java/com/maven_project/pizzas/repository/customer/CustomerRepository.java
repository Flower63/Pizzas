package com.maven_project.pizzas.repository.customer;

import com.maven_project.pizzas.domain.Customer;

public interface CustomerRepository {
	Customer findCustomer(Integer id);
	
	Integer saveCustomer(Customer customer);
	
	boolean updateCustomer(Customer customer);
	
	boolean deleteCustomer(Customer customer);
}
