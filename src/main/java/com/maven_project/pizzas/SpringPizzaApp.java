package com.maven_project.pizzas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.order.OrderService;

public class SpringPizzaApp {
	public static void main(String[] args) {
		Customer customer = new Customer(1, "John", null);
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("appContext.xml");
	
		OrderService orderService = (OrderService) ac.getBean("orderService");
	
		Order order = orderService.placeNewOrder(customer, 1, 2, 3);

    	System.out.println(order);
    
    	System.out.println(orderService.countTotalCost(order));
    
    	System.out.println(orderService.calculateDiscount(order));
    
    	//Pizza p = ac.getBean(Pizza.class);

		//System.out.println(p);

		((AbstractApplicationContext) ac).close();
	}
}
