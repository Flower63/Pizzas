package com.maven_project.pizzas;

public class PizzaApp {

	public static void main(String[] args) {
		Customer customer = null;

        Order order;

        OrderService orderService = new SimpleOrderService();

        order = orderService.placeNewOrder(customer, 1, 2, 3);

        System.out.println(order);
	}

}
