package com.maven_project.pizzas.web.utils.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.web.controller.app.PizzaController;
import com.maven_project.pizzas.web.controller.rest.PizzaRestController;
import com.maven_project.pizzas.web.utils.resource.PizzaResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PizzaResourceAssembler extends ResourceAssemblerSupport<Pizza, PizzaResource> {

	public PizzaResourceAssembler() {
		super(PizzaController.class, PizzaResource.class);
	}

	@Override
	public PizzaResource toResource(Pizza entity) {
		PizzaResource pizzaResource = super.createResourceWithId(entity.getPizzaId(), entity);
		pizzaResource.setName(entity.getName());
		pizzaResource.setPrice(entity.getPrice());
		pizzaResource.setType(entity.getType());
		
		pizzaResource.add(linkTo(methodOn(PizzaRestController.class).getAll()).withRel("all"));
			
		return pizzaResource;
	}
	
	public Pizza toEntity(PizzaResource resource) {
		Pizza pizza = new Pizza();
		
		pizza.setPizzaId(resource.getPizzaId());
		pizza.setName(resource.getName());
		pizza.setType(resource.getType());
		pizza.setPrice(resource.getPrice());
		
		return pizza;
	}
}
