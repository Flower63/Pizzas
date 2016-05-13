package com.maven_project.pizzas.service.customer;

import org.junit.Before;
import org.junit.Test;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.customer.CustomerRepository;

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
		
		verify(customerRepository).findCustomer(5);
	}

	@Test
	public void testSaveCustomer() {
		Customer customer = new Customer();
		
		customerService.saveCustomer(customer);
		
		verify(customerRepository).saveCustomer(customer);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = new Customer();
		
		customerService.updateCustomer(customer);
		
		verify(customerRepository).updateCustomer(customer);
	}

	@Test
	public void testDeleteCustomer() {
		Customer customer = new Customer();
		
		customerService.deleteCustomer(customer);
		
		verify(customerRepository).deleteCustomer(customer);
	}

}
