package com.maven_project.pizzas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven_project.pizzas.repository.pizza.PizzaRepository;

public class SpringPizzaApp {

	public static void main(String[] args) throws Exception {
		Customer customer = null;

        Order order;
        
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
		
		PizzaRepository pr = (PizzaRepository) appContext.getBean("pizzaRepository");
		
		System.out.println(pr.getPizzaByID(1));

        OrderService orderService = (OrderService) appContext.getBean("orderService");

        order = orderService.placeNewOrder(customer, 1, 2, 3);

        System.out.println(order);

        ((AbstractApplicationContext) appContext).close();
	}

}
