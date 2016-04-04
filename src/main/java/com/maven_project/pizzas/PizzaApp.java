package com.maven_project.pizzas;

import com.maven_project.pizzas.ifrastructure.ApplicationContext;
import com.maven_project.pizzas.ifrastructure.JavaConfigApplicationContext;
import com.maven_project.pizzas.ifrastructure.JavaConfigApplicationContext.BeanBuilder;
import com.maven_project.pizzas.ifrastructure.ServiceLocator;
import com.maven_project.pizzas.repository.pizza.InMemPizzaRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

public class PizzaApp {

	public static void main(String[] args) throws Exception {
		Customer customer = null;

        Order order;
        
        ApplicationContext ac = new JavaConfigApplicationContext();
        PizzaRepository pizzaRepository = (PizzaRepository) ac.getBean("pizzaRepository");
        
        System.out.println(pizzaRepository.getPizzaByID(1));

        OrderService orderService = (OrderService) ac.getBean("orderService");

        order = orderService.placeNewOrder(customer, 1, 2, 3);

        System.out.println(order);
        
        BeanBuilder bb = new BeanBuilder(InMemPizzaRepository.class, ac);
        
        bb.createBean();
        bb.callPostConstructMethod();
        PizzaRepository pp = (PizzaRepository) bb.createBeanProxy();
        
        System.out.println(pp.getPizzaByID(1));
	}

}
