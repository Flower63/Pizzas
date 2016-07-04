package com.maven_project.pizzas.web.utils.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.web.controller.app.PizzaController;
import com.maven_project.pizzas.web.utils.resource.PizzaResource;

@Component
public class PizzaResourceAssembler extends ResourceAssemblerSupport<Pizza, PizzaResource> {

	public PizzaResourceAssembler() {
		super(PizzaController.class, PizzaResource.class);
	}

	@Override
	public PizzaResource toResource(Pizza entity) {
		PizzaResource pizzaResource = new PizzaResource();
		pizzaResource.setPizzaId(entity.getPizzaId());
		pizzaResource.setName(entity.getName());
		pizzaResource.setPrice(entity.getPrice());
		pizzaResource.setType(entity.getType());
		
		//TODO add links
		
		return pizzaResource;
	}
}
