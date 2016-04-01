package com.maven_project.pizzas.ifrastructure;

import java.util.HashMap;
import java.util.Map;

import com.maven_project.pizzas.SimpleOrderService;
import com.maven_project.pizzas.repository.order.InMemOrderRepository;
import com.maven_project.pizzas.repository.pizza.InMemPizzaRepository;

public class JavaConfig implements Config {
	
	private Map<String, Class<?>> beans = new HashMap<>();
	
	{
		beans.put("orderRepository", InMemOrderRepository.class);
		beans.put("pizzaRepository", InMemPizzaRepository.class);
		beans.put("orderService", SimpleOrderService.class);
	}

	@Override
	public Class<?> getImpl(String bean) {
		return beans.get(bean);
	}

}
