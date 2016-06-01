package com.maven_project.pizzas;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.ifrastructure.ApplicationContext;
import com.maven_project.pizzas.ifrastructure.JavaConfigApplicationContext;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

public class PizzaApp {

	public static void main(String[] args) throws Exception {
		Customer customer = null;

        Order order;
        
        ApplicationContext ac = new JavaConfigApplicationContext();
        
        PizzaRepository pizzaRepository = (PizzaRepository) ac.getBean("pizzaRepository");
        
        //System.out.println(pizzaRepository.getPizzaByID(1));

        OrderService orderService = (OrderService) ac.getBean("orderService");

        order = orderService.placeNewOrder(customer, 1, 2, 3);

        System.out.println(order);
	}

}
