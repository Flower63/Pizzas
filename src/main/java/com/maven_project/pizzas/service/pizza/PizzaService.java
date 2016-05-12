package com.maven_project.pizzas.service.pizza;

import com.maven_project.pizzas.domain.Pizza;

/**
 * Created by Dennis
 *
 * on 5/12/2016.
 */
public interface PizzaService {
    Pizza getPizzaByID(Integer id);

    Integer savePizza(Pizza pizza);

    boolean deletePizza(Pizza pizza);

    boolean updatePizza(Pizza pizza);
}
