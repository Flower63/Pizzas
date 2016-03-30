package com.maven_project.pizzas.repository.order;

import com.maven_project.pizzas.Order;

public interface OrderRepository {
	Long saveOrder(Order order);
}
