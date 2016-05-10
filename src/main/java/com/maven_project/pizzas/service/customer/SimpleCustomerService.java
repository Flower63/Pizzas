package com.maven_project.pizzas.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.customer.CustomerRepository;

@Service("customerService")
public class SimpleCustomerService implements CustomerService {
	
	private CustomerRepository customerRepository;

	@Autowired
	public SimpleCustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer findCustomer(Integer id) {
		return customerRepository.findCustomer(id);
	}

	@Override
	public Integer saveCustomer(Customer customer) {
		return customerRepository.saveCustomer(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return customerRepository.updateCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		return customerRepository.deleteCustomer(customer);
	}

}
