package com.maven_project.pizzas.repository.pizza;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maven_project.pizzas.domain.Pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Dennis
 *
 * on 5/6/2016.
 */
@Deprecated
@Transactional
@Repository//("pizzaRepository")
public class JpaPizzaRepository implements PizzaRepository {

    @PersistenceContext
    private EntityManager em;

    public Pizza getPizzaByID(Integer id) {
        return em.find(Pizza.class, id);
    }

    public int savePizza(Pizza pizza) {
    	if (pizza.getPizzaId() != null) {
    		updatePizza(pizza);
    		
    		return pizza.getPizzaId();
    	}
    	
        em.persist(pizza);

        return pizza.getPizzaId();
    }

    public boolean deletePizza(Pizza pizza) {
        Pizza temp = em.find(Pizza.class, pizza.getPizzaId());

        if (temp == null) {
            return false;
        }

        em.remove(temp);

        return true;
    }

    public boolean updatePizza(Pizza pizza) {
    	Pizza temp = em.find(Pizza.class, pizza.getPizzaId());

        if (temp == null) {
            return false;
        }

        em.merge(pizza);

        return true;
    }
    
	public List<Pizza> getAllPizzas() {
		Query query = em.createQuery("SELECT e FROM Pizza e");
		
		List<Pizza> result = query.getResultList();
		
		return result;
	}

	@Override
	public <S extends Pizza> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pizza> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Pizza> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Pizza> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pizza entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Pizza> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
