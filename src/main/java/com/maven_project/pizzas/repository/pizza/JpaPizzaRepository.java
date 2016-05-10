package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.Pizza;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dennis
 *
 * on 5/6/2016.
 */
@Transactional
@Repository("pizzaRepository")
public class JpaPizzaRepository implements PizzaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Pizza getPizzaByID(Integer id) {
        return em.find(Pizza.class, id);
    }

    @Override
    public int savePizza(Pizza pizza) {
        em.persist(pizza);

        return pizza.getId();
    }

    @Override
    public boolean deletePizza(Pizza pizza) {
        Pizza temp = em.find(Pizza.class, pizza.getId());

        if (temp == null) {
            return false;
        }

        em.remove(temp);

        return true;
    }

    @Override
    public boolean updatePizza(Pizza pizza) {
        return false;
    }
}
