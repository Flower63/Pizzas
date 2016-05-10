package com.maven_project.pizzas.repository.order;

import com.maven_project.pizzas.domain.Order;

public interface OrderRepository {
	Long saveOrder(Order order);
	
	Order findOrder(Long id);
	
	boolean updateOrder(Order order);
	
	boolean deleteOrder(Order order);
}
