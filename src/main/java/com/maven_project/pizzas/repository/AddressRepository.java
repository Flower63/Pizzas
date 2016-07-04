package com.maven_project.pizzas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.Address;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Integer> {
}
