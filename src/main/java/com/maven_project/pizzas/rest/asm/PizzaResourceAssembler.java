package com.maven_project.pizzas.rest.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.rest.PizzaResource;
import com.maven_project.pizzas.web.controller.PizzaController;

@Component
public class PizzaResourceAssembler extends ResourceAssemblerSupport<Pizza, PizzaResource> {

	public PizzaResourceAssembler() {
		super(PizzaController.class, PizzaResource.class);
	}

	@Override
	public PizzaResource toResource(Pizza pizza) {
		PizzaResource result = new PizzaResource();
		result.setPizzaId(pizza.getPizzaId());
		result.setName(pizza.getName());
		result.setType(pizza.getType());
		result.setCost(pizza.getCost());
		
		return result;
	}
}
