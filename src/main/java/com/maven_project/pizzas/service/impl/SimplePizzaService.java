package com.maven_project.pizzas.service.impl;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.PizzaRepository;
import com.maven_project.pizzas.service.PizzaService;
import com.maven_project.pizzas.web.utils.asm.PizzaResourceAssembler;
import com.maven_project.pizzas.web.utils.resource.PizzaResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dennis
 *
 * on 5/12/2016.
 */
@Service
public class SimplePizzaService implements PizzaService {

	private final PizzaRepository pizzaRepository;

	private final PizzaResourceAssembler assembler;

	@Autowired
	public SimplePizzaService(PizzaRepository pizzaRepository, PizzaResourceAssembler assembler) {
		this.pizzaRepository = pizzaRepository;
		this.assembler = assembler;

	}

	@Override
	public Pizza getPizzaByID(Integer id) {
		return pizzaRepository.findOne(id);
	}

	@Override
	public Integer savePizza(Pizza pizza) {
		return pizzaRepository.save(pizza).getPizzaId();
	}

	@Override
	public void deletePizza(Integer pizzaId) {
		pizzaRepository.delete(pizzaId);
	}

	@Override
	public Iterable<Pizza> getAll() {
		return pizzaRepository.findAll();
	}

	/*
	 * @see
	 * com.maven_project.pizzas.service.PizzaService#create(com.maven_project.
	 * pizzas.web.utils.resource.PizzaResource)
	 */
	@Override
	public PizzaResource create(PizzaResource pizzaResource) {
		Pizza result = pizzaRepository.save(assembler.toEntity(pizzaResource));

		return assembler.toResource(result);
	}

	/*
	 * @see
	 * com.maven_project.pizzas.service.PizzaService#update(com.maven_project.
	 * pizzas.web.utils.resource.PizzaResource)
	 */
	@Override
	public PizzaResource update(PizzaResource pizzaResource) {
		Pizza result = pizzaRepository.save(assembler.toEntity(pizzaResource));

		return assembler.toResource(result);
	}
}
