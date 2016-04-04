package com.maven_project.pizzas;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.ifrastructure.ServiceLocator;
import com.maven_project.pizzas.repository.order.InMemOrderRepository;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.repository.pizza.InMemPizzaRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

public class SimpleOrderService implements OrderService {
	
	private OrderRepository orderRepository;
	private PizzaRepository pizzaRepository;
	
	public SimpleOrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository) {
		this.orderRepository = orderRepository;
		this.pizzaRepository = pizzaRepository;
	}

	@Override
	public Order placeNewOrder(Customer customer, Integer ... pizzasID) {

        List<Pizza> pizzas = new ArrayList<>();

        for(Integer id : pizzasID) {
        	pizzas.add(pizzaRepository.getPizzaByID(id));  // get Pizza from predifined in-memory list
        }

        Order newOrder = new Order(customer, pizzas);

        orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list

        return newOrder;

	}
}
