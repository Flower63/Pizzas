package com.maven_project.pizzas.web.controller.rest;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.service.PizzaService;
import com.maven_project.pizzas.web.utils.asm.PizzaResourceAssembler;
import com.maven_project.pizzas.web.utils.resource.PizzaResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pizza")
public class PizzaRestController {
	
	private final PizzaService pizzaService;
	private final PizzaResourceAssembler assembler;

	@Autowired
	public PizzaRestController(PizzaService pizzaService, PizzaResourceAssembler assembler) {
		this.pizzaService = pizzaService;
		this.assembler = assembler;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PizzaResource> getOne(@PathVariable Integer id) {
		Pizza pizza = pizzaService.getPizzaByID(id);
		
		if (pizza == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(assembler.toResource(pizza), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<PizzaResource>> getAll() {
		return new ResponseEntity<>(assembler.toResources(pizzaService.getAll()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PizzaResource> create(@RequestBody @Valid PizzaResource pizzaResource) {
		PizzaResource result = pizzaService.create(pizzaResource);
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<PizzaResource> update(@RequestBody @Valid PizzaResource pizzaResource) {
		PizzaResource result = pizzaService.update(pizzaResource);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PizzaResource> delete(@PathVariable Integer id) {
		pizzaService.deletePizza(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
