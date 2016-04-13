package com.maven_project.pizzas;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.order.OrderService;

public class SpringPizzaApp {
	public static void main(String[] args) {
		Customer customer = new Customer(1, "John", null);
		
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"appContext.xml"}, false);

		ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryContext.xml");

		appContext.setParent(repositoryContext);
		appContext.refresh();
	
		OrderService orderService = (OrderService) appContext.getBean("orderService");
	
		Order order = orderService.placeNewOrder(customer, 1, 2, 3);

    	System.out.println(order);
    
    	System.out.println(orderService.countTotalCost(order));
    
    	System.out.println(orderService.calculateDiscount(order));
    
    	//Pizza p = appContext.getBean(Pizza.class);

		//System.out.println(p);

		appContext.close();
	}
}
