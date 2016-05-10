package com.maven_project.pizzas.service.customer;

import com.maven_project.pizzas.domain.Customer;

public interface CustomerService {
	Customer findCustomer(Integer id);
	
	Integer saveCustomer(Customer customer);
	
	boolean updateCustomer(Customer customer);
	
	boolean deleteCustomer(Customer customer);
}
