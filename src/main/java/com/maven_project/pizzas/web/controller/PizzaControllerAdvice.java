package com.maven_project.pizzas.web.controller;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.maven_project.pizzas.Pizza;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

@ControllerAdvice
public class PizzaControllerAdvice {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@ModelAttribute("pizza")
	public Pizza findPizza(@RequestParam(value = "pizzaId", required = false) Integer pizzaId) {
		
		if (pizzaId == null) {
			return new Pizza();
		}
		
		Pizza pizza = pizzaRepository.getPizzaByID(pizzaId);
		System.out.println(pizza);
		return pizza;
	}
	
	
	//@InitBinder
	public void initBindere(WebDataBinder binder) {
		binder.registerCustomEditor(Pizza.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String pizzaId) throws IllegalArgumentException {
				Pizza pizza;
				
				if((pizzaId == null) || pizzaId.isEmpty()) {
					pizza = new Pizza();
				} else {
					pizza = pizzaRepository.getPizzaByID(Integer.valueOf(pizzaId));
				}
				
				setValue(pizza);
			}
			
		});
	}
}
