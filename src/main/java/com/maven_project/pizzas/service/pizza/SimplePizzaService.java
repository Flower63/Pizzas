package com.maven_project.pizzas.service.pizza;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dennis
 *
 * on 5/12/2016.
 */
@Service("pizzaService")
public class SimplePizzaService implements PizzaService {

    private PizzaRepository pizzaRepository;

    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}

	@Override
    public Pizza getPizzaByID(Integer id) {
        return pizzaRepository.getPizzaByID(id);
    }

    @Override
    public Integer savePizza(Pizza pizza) {
        return pizzaRepository.savePizza(pizza);
    }

    @Override
    public boolean deletePizza(Pizza pizza) {
        return pizzaRepository.deletePizza(pizza);
    }

    @Override
    public boolean updatePizza(Pizza pizza) {
        return pizzaRepository.updatePizza(pizza);
    }
}
