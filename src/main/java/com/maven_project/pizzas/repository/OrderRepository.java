package com.maven_project.pizzas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
