package com.maven_project.pizzas.service.order;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;

import java.util.List;

public interface OrderService {

	Order placeNewOrder(Customer customer, Integer... pizzasID);
	
	void proceedOrder(Order order);

	boolean alterOrder(Order order, List<Pizza> pizzas);
	
	void cancelOrder(Order order);

	double countTotalCost(Order order);
}