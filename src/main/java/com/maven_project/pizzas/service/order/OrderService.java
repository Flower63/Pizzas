package com.maven_project.pizzas.service.order;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;

public interface OrderService {

	Order placeNewOrder(Customer customer, Integer... pizzasID);
	
	void proceedOrder(Order order);
	
	void cancelOrder(Order order);

	double countTotalCost(Order order);
}