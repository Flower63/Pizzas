package com.maven_project.pizzas.service;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.web.utils.resource.PizzaResource;

/**
 * Created by Dennis
 *
 * on 5/12/2016.
 */
public interface PizzaService {
    Pizza getPizzaByID(Integer id);

    Integer savePizza(Pizza pizza);

    void deletePizza(Integer pizzaId);
    
    Iterable<Pizza> getAll();

	/**
	 * @param pizzaResource
	 * @return
	 */
	PizzaResource create(PizzaResource pizzaResource);

	/**
	 * @param pizzaResource
	 * @return
	 */
	PizzaResource update(PizzaResource pizzaResource);
}
