package com.maven_project.pizzas.repository.order;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.Order;

public class InMemOrderRepository implements OrderRepository {
	private List<Order> orders = new ArrayList<>();

	@Override
	public Long saveOrder(Order order) {
		orders.add(order);
		return order.getId();
	}

}
