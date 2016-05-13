package com.maven_project.pizzas.web.infrastructure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.maven_project.pizzas.web.Controller;
import com.maven_project.pizzas.web.GetPizzaController;
import com.maven_project.pizzas.web.HelloController;

public class SpringUrlHandlerMapping implements HandlerMapping {
	
	private ApplicationContext webContext;
	private static Map<String, Controller> mapping = new HashMap<>();

	public SpringUrlHandlerMapping(ConfigurableApplicationContext applicationContext) {
		this.webContext = applicationContext;
		mapping.put("/pizza", webContext.getBean(GetPizzaController.class));
		mapping.put("/hello", webContext.getBean(HelloController.class));
	}

	@Override
	public Controller getController(String controllerName) {
		return mapping.get(controllerName);
	}

}
