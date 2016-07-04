package com.maven_project.pizzas.service.customer;

import org.junit.Before;
import org.junit.Test;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.CustomerRepository;
import com.maven_project.pizzas.service.CustomerService;
import com.maven_project.pizzas.service.impl.SimpleCustomerService;

import static org.mockito.Mockito.*;

public class SimpleCustomerServiceTest {
	
	private CustomerService customerService;
	private CustomerRepository customerRepository;
	
	@Before
	public void makeService() {
		
		customerRepository = mock(CustomerRepository.class);
		
		customerService = new SimpleCustomerService(customerRepository);
	}

	@Test
	public void testFindCustomer() {
		customerService.findCustomer(5);
		
		verify(customerRepository).findOne(5);
	}

	@Test
	public void testSaveCustomer() {
		Customer customer = new Customer();
		
		customerService.saveCustomer(customer);
		
		verify(customerRepository).save(customer);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = new Customer();
		
		customerService.saveCustomer(customer);
		
		verify(customerRepository).save(customer);
	}

	@Test
	public void testDeleteCustomer() {
		Customer customer = new Customer();
		
		customerService.deleteCustomer(customer);
		
		verify(customerRepository).delete(customer);
	}

}
