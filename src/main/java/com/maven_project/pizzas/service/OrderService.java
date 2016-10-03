package com.maven_project.pizzas.service;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.web.utils.resource.OrderDtoResource;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface OrderService {
	void proceedOrder(Order order);

	boolean alterOrder(Order order, Map<Pizza, Integer> pizzas);
	
	void cancelOrder(Order order);

	double countTotalCost(Order order);
	
	double calculateDiscount(Order order);

	Order placeNewOrder(Customer customer, List<Integer> pizzasID, Address address);

	/**
	 * @param pageable
	 * @return
	 */
	Iterable<OrderDtoResource> getAll(Pageable pageable);
}