package com.maven_project.pizzas.service.impl;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.PizzaRepository;
import com.maven_project.pizzas.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dennis
 *
 * on 5/12/2016.
 */
@Service
public class SimplePizzaService implements PizzaService {

    private PizzaRepository pizzaRepository;

    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
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
    public boolean deletePizza(Integer pizzaId) {
        try {
        	pizzaRepository.delete(pizzaId);
        } catch (Exception e) {
        	return false;
        }
        
        return true;
    }

	@Override
	public Iterable<Pizza> getAll() {
		return pizzaRepository.findAll();
	}
}
