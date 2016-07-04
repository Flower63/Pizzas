package com.maven_project.pizzas.web.controller.rest;

import com.maven_project.pizzas.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaRestController {
	
	private final PizzaService pizzaService;

	@Autowired
	public PizzaRestController(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}
}
