package com.maven_project.pizzas;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.order.OrderService;
import com.maven_project.pizzas.service.order.SimpleOrderService;

public class PizzaApp {

	public static void main(String[] args) {
		Customer customer = new Customer(1, "John", null);

        Order order;

        OrderService orderService = new SimpleOrderService();

        order = orderService.placeNewOrder(customer, 1, 2, 3);

        System.out.println(order);
	}

}
