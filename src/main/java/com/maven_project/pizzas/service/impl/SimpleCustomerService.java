package com.maven_project.pizzas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.CustomerRepository;
import com.maven_project.pizzas.service.CustomerService;

@Service
public class SimpleCustomerService implements CustomerService {
	
	private CustomerRepository customerRepository;

	@Autowired
	public SimpleCustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer findCustomer(Integer id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Integer saveCustomer(Customer customer) {
		return customerRepository.save(customer).getId();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	@Override
	public Customer findCustomer(String email) {
		return customerRepository.findByEmail(email);
	}

}
