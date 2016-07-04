package com.maven_project.pizzas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
	Customer findByEmail(String email);
}
