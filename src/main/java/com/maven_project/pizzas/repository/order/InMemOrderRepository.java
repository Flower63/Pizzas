package com.maven_project.pizzas.repository.order;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.Order;
import org.springframework.stereotype.Repository;

@Repository("orderRepository")
public class InMemOrderRepository implements OrderRepository {
	private List<Order> orders = new ArrayList<>();

	public Long saveOrder(Order order) {
		orders.add(order);
		return order.getId();
	}

	@Override
	public <S extends Order> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Order> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Order> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Order entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Order> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
