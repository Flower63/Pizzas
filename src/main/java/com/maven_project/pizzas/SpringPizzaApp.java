package com.maven_project.pizzas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven_project.pizzas.repository.pizza.PizzaRepository;

public class SpringPizzaApp {

	public static void main(String[] args) throws Exception {
		Customer customer = null;

        Order order;
        
		ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryContext.xml");
		
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"appContext.xml"}, false);
		
		appContext.setParent(repositoryContext);
		appContext.refresh();
		
		PizzaRepository pr = (PizzaRepository) appContext.getBean("pizzaRepository");
		
		System.out.println(pr.getPizzaByID(1));

        OrderService orderService = (OrderService) appContext.getBean("orderService");
        //((SimpleOrderService) orderService).setAppContext(appContext);
        order = orderService.placeNewOrder(customer, 1, 2, 3);
        
        //System.out.println(((SimpleOrderService) orderService).getCustomer());
        
        System.out.println(orderService.getClass());

        System.out.println(order);

        ApplicationContext ap = appContext.getParent();
        
        System.out.println(ap);
        
        Customer customer2 = repositoryContext.getBean(Customer.class);
        
        System.out.println(customer2);
        
        ((AbstractApplicationContext) appContext).close();
	}

}
