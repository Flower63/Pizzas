package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.domain.Pizza;

import javax.persistence.EntityManager;

/**
 * Created by Dennis
 *
 * on 4/27/2016.
 */
public class JpaPizzaRepository implements PizzaRepository {
    private final EntityManager manager;

    public JpaPizzaRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Integer savePizza(Pizza pizza) {
        manager.getTransaction().begin();
        manager.persist(pizza);
        manager.getTransaction().commit();

        return pizza.getId();
    }

    @Override
    public Pizza getPizzaByID(Integer id) {
        return manager.find(Pizza.class, id);
    }
}
