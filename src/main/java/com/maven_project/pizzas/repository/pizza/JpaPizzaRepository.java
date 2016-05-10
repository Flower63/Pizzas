package com.maven_project.pizzas.repository.pizza;

import com.maven_project.pizzas.domain.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dennis
 *
 * on 4/27/2016.
 */
@Repository("pizzaRepository")
@Transactional
public class JpaPizzaRepository implements PizzaRepository {
	
	@PersistenceContext
    private EntityManager manager;

    @Override
    public Integer savePizza(Pizza pizza) {
        manager.persist(pizza);

        return pizza.getId();
    }

    @Override
    public Pizza getPizzaByID(Integer id) {
        return manager.find(Pizza.class, id);
    }

	@Override
	public boolean deletePizza(Pizza pizza) {
		Pizza temp = manager.find(Pizza.class, pizza.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.remove(temp);
		
		return true;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {
		Pizza temp = manager.find(Pizza.class, pizza.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.merge(pizza);
		
		return true;
	}
}
