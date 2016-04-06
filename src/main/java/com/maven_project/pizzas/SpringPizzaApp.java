package com.maven_project.pizzas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven_project.pizzas.repository.pizza.PizzaRepository;

public class SpringPizzaApp {

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
		
		PizzaRepository pr = (PizzaRepository) appContext.getBean("pizzaRepository");
		
		System.out.println(pr.getPizzaByID(1));
		
		((AbstractApplicationContext) appContext).close();

	}

}
