package com.maven_project.pizzas.ifrastructure;

import com.maven_project.pizzas.repository.pizza.PizzaRepository;

public interface ApplicationContext {

	Object getBean(String bean) throws Exception;

}
