package com.maven_project.pizzas.web.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.maven_project.pizzas.Pizza;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

@Component
public class PizzaConverter implements Converter<String, Pizza> {
	
	@Autowired
	private PizzaRepository pizzaRepository;

	@Override
	public Pizza convert(String pizzaId) {
		
		if (pizzaId == null || pizzaId.isEmpty()) {
			return null;
		}
		
		return pizzaRepository.getPizzaByID(Integer.valueOf(pizzaId));
	}
}
