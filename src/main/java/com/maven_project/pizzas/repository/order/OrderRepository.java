package com.maven_project.pizzas.repository.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	//Long saveOrder(Order order);
}
