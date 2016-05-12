package com.maven_project.pizzas.repository.customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maven_project.pizzas.domain.Customer;

@Repository("customerRepository")
@Transactional
public class JpaCustomerRepository implements CustomerRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Customer findCustomer(Integer id) {
		return manager.find(Customer.class, id);
	}

	@Override
	public Integer saveCustomer(Customer customer) {
		manager.persist(customer);
		
		return customer.getId();
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		Customer temp = manager.find(Customer.class, customer.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.merge(customer);
		
		return true;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		Customer temp = manager.find(Customer.class, customer.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.remove(temp);
		
		return true;
	}

}
