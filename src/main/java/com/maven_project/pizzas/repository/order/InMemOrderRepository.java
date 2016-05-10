package com.maven_project.pizzas.repository.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.Order;

@Repository(value="inMemOrderRepository")
public class InMemOrderRepository implements OrderRepository {
	private List<Order> orders = new ArrayList<>();

	@Override
	public Long saveOrder(Order order) {
		orders.add(order);
		return order.getId();
	}

	@Override
	public Order findOrder(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
